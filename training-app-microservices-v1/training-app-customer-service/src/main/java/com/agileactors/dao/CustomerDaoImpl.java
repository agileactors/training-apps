package com.agileactors.dao;

import com.agileactors.data.jpa.repository.CustomerRepository;
import com.agileactors.domain.Customer;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
class CustomerDaoImpl extends AbstractDaoImpl<Customer, UUID, CustomerRepository>
    implements CustomerDao {
  public CustomerDaoImpl(CustomerRepository jpaRepository) {
    super(jpaRepository);
  }
}
