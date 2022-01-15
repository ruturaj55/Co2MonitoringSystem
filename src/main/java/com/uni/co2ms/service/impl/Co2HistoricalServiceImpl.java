package com.uni.co2ms.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uni.co2ms.exception.RecordNotException;
import com.uni.co2ms.model.Co2HistoricalRecord;
import com.uni.co2ms.repository.HistoricalCo2RecordsRepository;
import com.uni.co2ms.service.Co2HistoricalService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Co2HistoricalServiceImpl implements Co2HistoricalService {
	private static final Logger log = LoggerFactory.getLogger(Co2HistoricalServiceImpl.class);

	@Autowired
	HistoricalCo2RecordsRepository historicalCo2RecordsRepository;

	@Override
	public List<Co2HistoricalRecord> getAllHistoricalCo2Records() {
		try {
			log.info("Fetching all historical records from Co2 Monitoring System from Historical Db");
			return historicalCo2RecordsRepository.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RecordNotException("Error occurred..");
		}

	}

	@Override
	public Co2HistoricalRecord getHistoricalCo2RecordById(Long id) {
		try {
			log.info("Fetching record from Historical Co2 Monitoring System by Id");
			Co2HistoricalRecord co2HistoricalRecord = historicalCo2RecordsRepository.findById(id).get();
			return co2HistoricalRecord;
		} catch (Exception e) {
			log.error("Error : " + e.getMessage());
			throw new RecordNotException("Record not found for given id");
		}
	}
	@Override
	public List<Co2HistoricalRecord> getHistoricalCo2RecordByCityAndDate(String city, LocalDateTime dateTime) {
		try {
			log.info("Fetching all historical records from Co2 Monitoring System from Historical Db by city and date");
			return historicalCo2RecordsRepository.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RecordNotException("Could not find record with given input");
		}
	}

	@Override
	public void addCo2FromSensorSystemToHistoricalDb(Co2HistoricalRecord co2HistoricalRecord) {
		try {
			log.info("Adding latest record recieved by central sensors for respective city in Historical Db");
			Co2HistoricalRecord newCo2Record = historicalCo2RecordsRepository.save(co2HistoricalRecord);
			log.info("Added new Record in co2 Historical db with id : " + newCo2Record.getId());
		} catch (Exception e) {
			log.error("Error  : " + e.getMessage());
			throw new RecordNotException(
					"Error occurred durring inserting new record in historical data ,please refer logs");
		}
		
	}

	


}
