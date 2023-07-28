package com.molog.memberapi.repository;

import com.molog.memberapi.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository implements MemberRepositoryInf{
    private final EntityManager em;

    @Override
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    @Override
    public Optional<Member> findOne(Long id) {
        Member result = em.find(Member.class, id);
        return Optional.ofNullable(result);
    }

    @Override
    public Optional<Member> findByMemberId(String memberId) {
        Member result = em.createQuery("select m from Member m where m.memberId =: memberId", Member.class)
                .setParameter("memberId", memberId)
                .getSingleResult();
        return Optional.ofNullable(result);
    }
}
