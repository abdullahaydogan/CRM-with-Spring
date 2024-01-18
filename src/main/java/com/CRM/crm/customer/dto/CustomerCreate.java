package com.CRM.crm.customer.dto;

import com.CRM.crm.customer.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerCreate(
        @NotBlank
        String customerName,
        @NotBlank
        String customerSurname,
        @NotBlank
        String customerClass,
        @Email
        String customerMail,
        @NotBlank
        String customerAdress,
        @NotBlank
        String customerPhone,
        @NotBlank
        Long price,
        @NotBlank
        Long installment
) {

    public Customer toCustomer() {
        Customer customer = new Customer();
        customer.setCustomerName(customerName);
        customer.setCustomerSurname(customerSurname);
        customer.setCustomerMail(customerMail);
        customer.setCustomerClass(customerClass);
        customer.setCustomerAdress(customerAdress);
        customer.setCustomerPhone(customerPhone);
        customer.setInstallment(installment);
        return customer;
    }


}
