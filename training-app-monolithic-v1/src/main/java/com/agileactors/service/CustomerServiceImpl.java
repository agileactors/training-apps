package com.agileactors.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agileactors.dao.CustomerDao;
import com.agileactors.domain.AuditLogType;
import com.agileactors.domain.Customer;
import com.agileactors.dto.audit.CreateAuditLogRequestDto;
import com.agileactors.dto.customer.AbstractCustomerDto;
import com.agileactors.dto.customer.CreateCustomerRequestDto;
import com.agileactors.dto.customer.UpdateCustomerRequestDto;

@Service
class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;
    private final AuditLogService auditLogService;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao, AuditLogService auditLogService) {
        this.customerDao = customerDao;
        this.auditLogService = auditLogService;
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

        auditLogService.save(new CreateAuditLogRequestDto(AuditLogType.CUSTOMER_INIT, newCustomer.getId()));

        return customerDao.save(copy(createCustomerRequestDto, newCustomer));
    }

    @Override
    @Transactional
    public Customer update(UpdateCustomerRequestDto updateCustomerRequestDto) {
        var customer = customerDao.getById(updateCustomerRequestDto.getId());

        auditLogService.save(new CreateAuditLogRequestDto(AuditLogType.CUSTOMER_UPDATE, customer.getId()));
        return copy(updateCustomerRequestDto, customer);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        auditLogService.save(new CreateAuditLogRequestDto(AuditLogType.CUSTOMER_DELETE, id));
        customerDao.deleteById(id);
    }

    private <T extends AbstractCustomerDto> Customer copy(T source, Customer customer) {
        customer.setFirstName(source.getFirstName());
        customer.setLastName(source.getLastName());
        customer.setEmail(source.getEmail());
        customer.setAddress(source.getAddress());
        return customer;
    }

}
