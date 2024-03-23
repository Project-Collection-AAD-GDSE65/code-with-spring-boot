package lk.ijse.gdse.aad65.HelloSpringBoot.service;

import lk.ijse.gdse.aad65.HelloSpringBoot.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public void deleteCustomer(String customerId) {

    }

    @Override
    public CustomerDTO getSelectedCustomer(String customerId) {
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return List.of();
    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {

    }
}
