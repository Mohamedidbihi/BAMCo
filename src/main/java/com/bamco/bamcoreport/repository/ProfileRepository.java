package com.bamco.bamcoreport.repository;

import com.bamco.bamcoreport.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long>
{
}
