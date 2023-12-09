package com.crudkotline.controller

import com.crudkotline.dto.RequestMember
import com.crudkotline.dto.RequestUpdateMember
import com.crudkotline.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class MemberController @Autowired constructor(val memberService: MemberService){

    @GetMapping("/{memberCode}")
    fun findMember(@PathVariable memberCode: Long): ResponseEntity<Any>{
        val member = memberService.getMember(memberCode)
        return ResponseEntity.ok().body(member)
    }

    @GetMapping("/findAll")
    fun findAllMember(): ResponseEntity<Any>{
        return ResponseEntity.ok().body(memberService.getMemberList())
    }

    @PostMapping("/create")
    fun createMember(@RequestBody requestMember: RequestMember): ResponseEntity<Any>{
        val save = memberService.save(requestMember)
        return ResponseEntity.ok().body(save)
    }

    @PutMapping("/{memberCode}")
    fun updateMember(@PathVariable memberCode: Long,
                     @RequestBody requestUpdateMember: RequestUpdateMember): ResponseEntity<Any>{
        val nickname = memberService.updateMember(memberCode, requestUpdateMember)
        return ResponseEntity.ok().body(nickname)
    }

    @DeleteMapping("/{memberCode}")
    fun deleteMember(@PathVariable memberCode: Long): ResponseEntity<Any>{
        memberService.deleteMember(memberCode)
        return ResponseEntity.ok().body(true)
    }





}