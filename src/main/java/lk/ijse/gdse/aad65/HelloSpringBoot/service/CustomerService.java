package lk.ijse.gdse.aad65.HelloSpringBoot.service;

import lk.ijse.gdse.aad65.HelloSpringBoot.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    void deleteCustomer(String customerId);
    CustomerDTO getSelectedCustomer(String customerId);
    List<CustomerDTO> getAllCustomers();
    void updateCustomer(String customerId,CustomerDTO customerDTO);
}
