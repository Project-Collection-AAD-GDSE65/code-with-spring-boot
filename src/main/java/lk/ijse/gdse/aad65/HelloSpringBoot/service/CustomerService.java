package lk.ijse.gdse.aad65.HelloSpringBoot.service;

import lk.ijse.gdse.aad65.HelloSpringBoot.dto.CustomerDTO;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    void deleteCustomer(String customerId);
    CustomerDTO getSelectedCustomer(String customerId);
    void updateCustomer(String customerId,CustomerDTO customerDTO);
}
