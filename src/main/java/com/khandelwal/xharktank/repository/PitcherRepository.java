package com.khandelwal.xharktank.repository;

import com.khandelwal.xharktank.entities.PitchersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PitcherRepository extends JpaRepository<PitchersEntity,Long> {
    @Query(value = "SELECT * from PITCHES ",nativeQuery = true)
    public List<PitchersEntity> xyz();
}
