package com.uni.co2ms.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uni.co2ms.model.Co2HistoricalRecord;

@Repository
public interface HistoricalCo2RecordsRepository extends JpaRepository<Co2HistoricalRecord, Long> {

	@Query("select c from Co2HistoricalRecord c where c.city = :city and c.recorDateTime = :recorDateTime")
	List<Co2HistoricalRecord> findRecordsByCityAndDate(@Param("city") String city,
			@Param("recorDateTime") LocalDateTime recorDateTime);
}
