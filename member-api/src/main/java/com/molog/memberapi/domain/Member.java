package com.molog.memberapi.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String memberId;
    @Column(nullable = false)
    private String memberPw;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String phoneNum;
    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @Builder
    public Member(String memberId, String memberPw, String name, String phoneNum, String email
            , Address address) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.address = address;
    }
}
