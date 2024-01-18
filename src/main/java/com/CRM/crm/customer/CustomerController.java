package com.CRM.crm.customer;

import com.CRM.crm.customer.dto.CustomerCreate;
import com.CRM.crm.shared.GenericMessage;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;
    Customer customer;

    @PostMapping("/api/v1/customersave")
    GenericMessage createCustomer(@Valid @RequestBody CustomerCreate customer) {
        customerService.saveCustomer(customer.toCustomer());
        return new GenericMessage("Customer is Created");
    }

    @GetMapping("api/v1/customers")
    Page<Customer> getCustomer(Pageable page) {
        return customerService.getCustomer(page);
    }

    @DeleteMapping("api/v1/customerDelete/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomerById(customerId);
        return ResponseEntity.ok("Customer is Deleted ");
    }


}
