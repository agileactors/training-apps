package com.agileactors.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agileactors.dao.AuditLogDao;
import com.agileactors.dao.ContractDao;
import com.agileactors.dao.CustomerDao;
import com.agileactors.domain.Customer;
import com.agileactors.dto.audit.AuditLogType;
import com.agileactors.dto.audit.CreateAuditLogRequestDto;
import com.agileactors.dto.customer.AbstractCustomerDto;
import com.agileactors.dto.customer.CreateCustomerRequestDto;
import com.agileactors.dto.customer.UpdateCustomerRequestDto;

@Service
class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;

    private final ContractDao contractDao;

    private final AuditLogDao auditLogDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao, ContractDao contractDao, AuditLogDao auditLogDao) {
        this.customerDao = customerDao;
        this.contractDao = contractDao;
        this.auditLogDao = auditLogDao;
    }

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    @Transactional
    public Customer getById(UUID id) {
        return customerDao.getById(id);
    }

    @Override
    @Transactional
    public Customer create(CreateCustomerRequestDto createCustomerRequestDto) {
        var newCustomer = new Customer();
        newCustomer.setId(UUID.randomUUID());

        auditLogDao.create(new CreateAuditLogRequestDto(AuditLogType.CUSTOMER_INIT, newCustomer.getId()));

        return customerDao.save(copy(createCustomerRequestDto, newCustomer));
    }

    @Override
    @Transactional
    public Customer update(UpdateCustomerRequestDto updateCustomerRequestDto) {
        var customer = customerDao.getById(updateCustomerRequestDto.getId());

        auditLogDao.create(new CreateAuditLogRequestDto(AuditLogType.CUSTOMER_UPDATE, customer.getId()));

        return copy(updateCustomerRequestDto, customer);
    }

    @Override
    @Transactional
    public void deleteById(UUID customerId) {
        customerDao.deleteById(customerId);
        /*
         * Remote service call to the contract service so that all contracts are deleted upon customer removal
         */
        auditLogDao.create(new CreateAuditLogRequestDto(AuditLogType.CUSTOMER_DELETE, customerId));
        contractDao.deleteByCustomerId(customerId);
    }

    private <T extends AbstractCustomerDto> Customer copy(T source, Customer customer) {
        customer.setFirstName(source.getFirstName());
        customer.setLastName(source.getLastName());
        customer.setEmail(source.getEmail());
        customer.setAddress(source.getAddress());
        return customer;
    }

}
