package com.molog.memberapi.repository;

import com.molog.memberapi.domain.Address;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AddressRepository implements AddressRepositoryInf {
    private final EntityManager em;

    @Override
    public Long save(Address address) {
        em.persist(address);
        return address.getId();
    }

    @Override
    public Optional<Address> findOne(Long id) {
        Address address = em.find(Address.class, id);
        return Optional.ofNullable(address);
    }
}
