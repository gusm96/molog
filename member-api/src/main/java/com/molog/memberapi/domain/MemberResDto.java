package com.molog.memberapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResDto {

    private String memberId;
    private String name;
    private String email;
    private Address address;

    @Builder
    public MemberResDto (Member member){
        this.memberId = member.getMemberId();
        this.name = member.getName();
        this.email = member.getEmail();
        this.address = member.getAddress();
    }
}
