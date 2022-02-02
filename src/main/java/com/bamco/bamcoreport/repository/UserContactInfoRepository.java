package com.bamco.bamcoreport.repository;

import com.bamco.bamcoreport.entity.UserContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserContactInfoRepository extends JpaRepository<UserContactInfo, Long> {
}
