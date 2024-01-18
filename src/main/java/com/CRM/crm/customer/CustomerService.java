package com.CRM.crm.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepositoryI customerRepositoryI;

    public void saveCustomer(Customer customer) {
        customerRepositoryI.save(customer);
    }

    public Page<Customer> getCustomer(Pageable page) {
        return customerRepositoryI.findAll(page);
    }

    public void deleteCustomerById(Long id) {
        customerRepositoryI.deleteById(id);
    }


}
