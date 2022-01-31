package com.bamco.bamcoreport.repository;

import com.bamco.bamcoreport.entity.Group;
import com.bamco.bamcoreport.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
        Group findById(long id);
}
