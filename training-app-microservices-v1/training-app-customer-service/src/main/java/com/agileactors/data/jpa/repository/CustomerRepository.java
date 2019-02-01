package com.agileactors.data.jpa.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.agileactors.domain.Customer;

@Repository
public interface CustomerRepository extends AbstractRepository<Customer, UUID> {
}
