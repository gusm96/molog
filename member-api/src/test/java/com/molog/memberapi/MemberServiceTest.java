package com.molog.memberapi;

import com.molog.memberapi.domain.Address;
import com.molog.memberapi.domain.Member;
import com.molog.memberapi.domain.MemberRegistrationReqDto;
import com.molog.memberapi.repository.AddressRepository;
import com.molog.memberapi.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @DisplayName("맴버 등록 테스트")
    @Test
    @Rollback(value = false)
    void 맴버_등록 () {
        // given
        MemberRegistrationReqDto newMember = MemberRegistrationReqDto.builder()
                .memberId("moya")
                .memberPw("moya1343")
                .name("성모")
                .phoneNum("010-1111-1111")
                .email("moya@moya.com")
                .city("서울특별시")
                .street("잠원동")
                .zipcode("12345")
                .build();
        // when
        Address address = newMember.toAddressEntity();
        Long addressId = addressRepository.save(address);
        Address findAddress = addressRepository.findOne(addressId).orElseThrow(() ->
            new IllegalStateException("주소 정보를 잘못 입력했습니다.")
        );
        String encodedPw = passwordEncoder.encode(newMember.getMemberPw());
        Member member = newMember.toMemberEntity(encodedPw, findAddress);
        Long result = memberRepository.save(member);

        // then
        Assertions.assertThat(result).isEqualTo(member.getId());
    }
}
