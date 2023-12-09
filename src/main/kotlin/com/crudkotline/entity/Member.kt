package com.crudkotline.entity

import com.crudkotline.dto.RequestUpdateMember
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.NoArgsConstructor


@Entity
@NoArgsConstructor
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var memberCode: Long,
    var id: String,
    var password: String,
    var nickname: String
){
    fun updateMember(requestUpdateMember: RequestUpdateMember){
        nickname = requestUpdateMember.nickname
    }
}