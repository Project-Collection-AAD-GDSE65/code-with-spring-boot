package lk.ijse.gdse.aad65.HelloSpringBoot.util;

import lk.ijse.gdse.aad65.HelloSpringBoot.contoller.Customer;
import lk.ijse.gdse.aad65.HelloSpringBoot.dto.CustomerDTO;
import lk.ijse.gdse.aad65.HelloSpringBoot.entity.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Mapping {
    private final ModelMapper mapper;

    public CustomerDTO toCustomerDTO(CustomerEntity customer) {
       return  mapper.map(customer, CustomerDTO.class);
    }
    public CustomerEntity toCustomer(CustomerDTO customerDTO) {
        return  mapper.map(customerDTO, CustomerEntity.class);
    }
    public List<CustomerDTO> toCustomerDTOList(List<CustomerEntity> customers) {
       return mapper.map(customers, List.class);
    }
}
