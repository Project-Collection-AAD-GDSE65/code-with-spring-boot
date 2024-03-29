package lk.ijse.gdse.aad65.HelloSpringBoot.dao;

import lk.ijse.gdse.aad65.HelloSpringBoot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<UserEntity,String> {
    Optional<UserEntity> findByEmail(String email);
}
