package com.agileactors.service;

import com.agileactors.dao.AuditLogDao;
import com.agileactors.dao.CustomerDao;
import com.agileactors.domain.Customer;
import com.agileactors.dto.audit.AuditLogType;
import com.agileactors.dto.audit.CreateAuditLogRequestDto;
import com.agileactors.dto.customer.CreateCustomerRequestDto;
import com.agileactors.dto.customer.GetCustomerDto;
import com.agileactors.dto.customer.UpdateCustomerRequestDto;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
class CustomerServiceImpl implements CustomerService {

  private final CustomerDao customerDao;
  private final AuditLogDao auditLogDao;
  private final ConversionService conversionService;

  @Autowired
  public CustomerServiceImpl(CustomerDao customerDao,
                             AuditLogDao auditLogDao,
                             ConversionService conversionService) {
    this.customerDao = customerDao;
    this.auditLogDao = auditLogDao;
    this.conversionService = conversionService;
  }

  @Override
  public List<GetCustomerDto> findAll() {
    return customerDao.findAll().stream()
        .map(customer -> conversionService.convert(customer, GetCustomerDto.class)).toList();
  }

  @Override
  public GetCustomerDto getById(UUID id) {
    return conversionService.convert(customerDao.getById(id), GetCustomerDto.class);
  }

  @Override
  public Customer getByIdNative(UUID id) {
    return customerDao.getById(id);
  }

  @Override
  @Transactional
  public GetCustomerDto create(CreateCustomerRequestDto createCustomerRequestDto) {
    var newCustomer = new Customer(UUID.randomUUID(), createCustomerRequestDto.getFirstName(),
        createCustomerRequestDto.getLastName(), createCustomerRequestDto.getEmail(),
        createCustomerRequestDto.getAddress());

    auditLogDao.create(
        new CreateAuditLogRequestDto(AuditLogType.CUSTOMER_INIT, newCustomer.getId()));

    return conversionService.convert(customerDao.save(newCustomer), GetCustomerDto.class);
  }

  @Override
  @Transactional
  public GetCustomerDto update(UUID customerId, UpdateCustomerRequestDto updateCustomerRequestDto) {
    var customer = customerDao.getById(customerId);

    customer.setAddress(updateCustomerRequestDto.getAddress());
    customer.setFirstName(updateCustomerRequestDto.getFirstName());
    customer.setLastName(updateCustomerRequestDto.getLastName());
    customer.setEmail(updateCustomerRequestDto.getEmail());

    auditLogDao.create(
        new CreateAuditLogRequestDto(AuditLogType.CUSTOMER_UPDATE, customer.getId()));

    return conversionService.convert(customerDao.save(customer), GetCustomerDto.class);
  }

  @Override
  @Transactional
  public void deleteById(UUID id) {
    auditLogDao.create(new CreateAuditLogRequestDto(AuditLogType.CUSTOMER_DELETE, id));
    customerDao.deleteById(id);
  }
}
