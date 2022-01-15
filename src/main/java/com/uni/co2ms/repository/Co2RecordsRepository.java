package com.uni.co2ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uni.co2ms.model.Co2Record;

@Repository
public interface Co2RecordsRepository extends JpaRepository<Co2Record, Long> {
	@Query("select c from Co2Record c where c.city = :city")
	Co2Record findByCity(@Param("city") String city);
}
