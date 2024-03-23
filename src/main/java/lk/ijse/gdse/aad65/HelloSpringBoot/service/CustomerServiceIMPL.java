package lk.ijse.gdse.aad65.HelloSpringBoot.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad65.HelloSpringBoot.dao.CustomerRepo;
import lk.ijse.gdse.aad65.HelloSpringBoot.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceIMPL implements CustomerService {
    private final CustomerRepo repo;
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
