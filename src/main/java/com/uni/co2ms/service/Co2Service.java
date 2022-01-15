package com.uni.co2ms.service;

import java.util.List;

import com.uni.co2ms.model.Co2Record;

public interface Co2Service {
	
	List<Co2Record> getAllCo2Records();

	Co2Record getCo2RecordById(Long id);

	Co2Record getLatestCo2RecordByCity(String city);

	void updateCo2FromSensorSystem();
}
