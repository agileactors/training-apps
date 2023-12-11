package com.agileactors.dao;

import com.agileactors.data.jpa.repository.ContractRepository;
import com.agileactors.domain.Contract;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
class ContractDaoImpl extends AbstractDaoImpl<Contract, UUID, ContractRepository>
    implements ContractDao {
  public ContractDaoImpl(ContractRepository jpaRepository) {
    super(jpaRepository);
  }
}
