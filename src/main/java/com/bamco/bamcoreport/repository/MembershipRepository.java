package com.bamco.bamcoreport.repository;

import com.bamco.bamcoreport.entity.UserMembership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends JpaRepository<UserMembership, Long> {
}
