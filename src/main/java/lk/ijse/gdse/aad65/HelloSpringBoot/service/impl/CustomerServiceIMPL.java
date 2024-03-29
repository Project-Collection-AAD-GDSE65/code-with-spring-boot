package lk.ijse.gdse.aad65.HelloSpringBoot.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad65.HelloSpringBoot.dao.CustomerRepo;
import lk.ijse.gdse.aad65.HelloSpringBoot.dto.CustomerDTO;
import lk.ijse.gdse.aad65.HelloSpringBoot.service.CustomerService;
import lk.ijse.gdse.aad65.HelloSpringBoot.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceIMPL implements CustomerService {
    private final CustomerRepo repo;
    private final Mapping mapping;
    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setCustomerId(UUID.randomUUID().toString());
        return mapping.toCustomerDTO(repo.save(mapping.toCustomer(customerDTO)));
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
        return mapping.toCustomerDTOList(repo.findAll());
    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {

    }
}
