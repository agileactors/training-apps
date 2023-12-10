package com.agileactors.data.jpa.repository;

import com.agileactors.domain.Customer;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends AbstractRepository<Customer, UUID> {
}
