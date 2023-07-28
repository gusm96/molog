package com.molog.memberapi.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberRegistrationReqDto {
    @NotEmpty
    private String memberId;
    @NotEmpty
    private String memberPw;
    @NotEmpty
    private String name;
    @NotEmpty
    private String phoneNum;
    @NotEmpty
    private String email;
    @NotEmpty
    private String city;
    @NotEmpty
    private String street;
    private String zipcode;

    @Builder
    public MemberRegistrationReqDto(
            String memberId, String memberPw, String name, String phoneNum
            , String email, String city, String street, String zipcode
    ) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public Address toAddressEntity() {
        Address address = Address.builder()
                .city(this.city)
                .street(this.street)
                .zipcode(this.zipcode)
                .build();
        return address;
    }

    public Member toMemberEntity(String encodedPw, Address address){
        Member member = Member.builder()
                .memberId(this.memberId)
                .memberPw(encodedPw)
                .name(this.name)
                .phoneNum(this.phoneNum)
                .email(this.email)
                .address(address).build();
        return member;
    }
}
