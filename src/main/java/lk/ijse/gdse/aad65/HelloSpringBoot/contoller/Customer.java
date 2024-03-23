package lk.ijse.gdse.aad65.HelloSpringBoot.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class Customer {
    @GetMapping("/health")
    public String healthTest(){
        return "CustomerHealth Test";
    }
}
