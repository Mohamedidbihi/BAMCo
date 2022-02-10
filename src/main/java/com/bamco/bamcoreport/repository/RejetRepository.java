package com.bamco.bamcoreport.repository;

import com.bamco.bamcoreport.entity.Rejet;
import com.bamco.bamcoreport.dto.CountDayDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RejetRepository extends JpaRepository<Rejet, Long> {
    @Query(nativeQuery = true)
    List<CountDayDto> getDailyCount();

    @Query(nativeQuery = true)
    List<CountDayDto> getRejetsByUser(@Param("user_id") long id);
}
