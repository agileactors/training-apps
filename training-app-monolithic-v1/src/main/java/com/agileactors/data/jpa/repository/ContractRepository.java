package com.agileactors.data.jpa.repository;

import com.agileactors.domain.Contract;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends AbstractRepository<Contract, UUID> {
}
