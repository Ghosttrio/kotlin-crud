package com.crudkotline.service

import com.crudkotline.dto.RequestMember
import com.crudkotline.dto.RequestUpdateMember
import com.crudkotline.entity.Member
import com.crudkotline.repository.MemberRepository
import jakarta.transaction.Transactional
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@Transactional
class MemberService @Autowired constructor(
        val memberRepository: MemberRepository,
        val modelMapper: ModelMapper
){

    fun getMember(memberCode: Long): String {
        return memberRepository.findById(memberCode).get().nickname;
    }

    fun getMemberList(): List<Member>{
        return memberRepository.findAll()
    }

    fun save(requestMember: RequestMember): Long{
        return memberRepository.save(modelMapper.map(requestMember, Member::class.java)).memberCode
    }
    fun updateMember(memberCode: Long, requestUpdateMember: RequestUpdateMember): String{
        val getMember = memberRepository.findById(memberCode).get()
        getMember.updateMember(requestUpdateMember)
        return getMember.nickname
    }

    fun deleteMember(memberCode: Long){
        memberRepository.deleteById(memberCode)
    }
}