package com.bamco.bamcoreport.repository;

import com.bamco.bamcoreport.entity.UserEntity;
import com.bamco.bamcoreport.entity.UserMembership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipRepository extends JpaRepository<UserMembership, Long> {

    UserMembership findByUserid(UserEntity userid);

    List<UserMembership> findUserMemberShipByUserid(UserEntity user);

}
