package com.agileactors.dao;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.agileactors.data.jpa.repository.CustomerRepository;
import com.agileactors.domain.Customer;

@Component
class CustomerDaoImpl extends AbstractDaoImpl<Customer, UUID, CustomerRepository>
    implements CustomerDao {
  public CustomerDaoImpl(CustomerRepository jpaRepository) {
    super(jpaRepository);
  }
}
