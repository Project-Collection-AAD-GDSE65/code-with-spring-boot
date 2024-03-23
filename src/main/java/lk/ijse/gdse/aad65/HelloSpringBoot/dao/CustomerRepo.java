package lk.ijse.gdse.aad65.HelloSpringBoot.dao;

import lk.ijse.gdse.aad65.HelloSpringBoot.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity,String> {
}
