package com.CRM.crm.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    Long id;
    @NotBlank
    String customerName;
    @NotBlank
    String customerSurname;
    @NotBlank
    String customerClass;
    @Email
    String customerMail;
    @NotBlank
    String customerAdress;
    @NotBlank
    String customerPhone;
    @NotBlank
    Long price;
    @NotBlank
    Long installment;


}
