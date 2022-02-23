package com.bamco.bamcoreport.repository;

import com.bamco.bamcoreport.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findById(long id);
    UserEntity findByUsername(String username);
}
