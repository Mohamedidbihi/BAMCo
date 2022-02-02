package com.bamco.bamcoreport.repository;

import com.bamco.bamcoreport.entity.ProfileMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileMemberRepository extends JpaRepository<ProfileMember, Long> {
}
