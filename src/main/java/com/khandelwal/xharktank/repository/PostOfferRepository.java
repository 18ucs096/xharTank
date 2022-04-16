package com.khandelwal.xharktank.repository;
import com.khandelwal.xharktank.entities.PitchersEntity;
import com.khandelwal.xharktank.entities.PostOfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostOfferRepository extends JpaRepository<PostOfferEntity,Long> {
    @Query(value = "SELECT * from COUNTER  where COUNTER.offer_id=:id",nativeQuery = true)
    public List<PostOfferEntity> getOffer(@Param("id") Long id);
}
