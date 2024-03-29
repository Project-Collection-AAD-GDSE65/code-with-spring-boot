package lk.ijse.gdse.aad65.HelloSpringBoot.contoller;

import lk.ijse.gdse.aad65.HelloSpringBoot.dto.CustomerDTO;
import lk.ijse.gdse.aad65.HelloSpringBoot.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class Customer {
    private final CustomerService customerService;

    @GetMapping("/health")
    public String healthTest(){
        return "CustomerHealth Test";
    }
    @PostMapping
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
