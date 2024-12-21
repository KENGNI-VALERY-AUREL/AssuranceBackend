package com.example.assbackend.Dao;

import com.example.assbackend.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email); // Use 'email' if that is the correct field for login
}
