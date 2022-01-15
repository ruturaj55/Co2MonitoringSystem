package com.uni.co2ms.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uni.co2ms.model.Co2HistoricalRecord;

public interface Co2HistoricalService {

	List<Co2HistoricalRecord> getAllHistoricalCo2Records();

	Co2HistoricalRecord getHistoricalCo2RecordById(Long id);

	List<Co2HistoricalRecord> getHistoricalCo2RecordByCityAndDate(String city, LocalDateTime dateTime);

	void addCo2FromSensorSystemToHistoricalDb(Co2HistoricalRecord co2HistoricalRecord);
}
