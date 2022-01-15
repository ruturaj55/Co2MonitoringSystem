package com.uni.co2ms.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.uni.co2ms.exception.RecordNotException;
import com.uni.co2ms.model.Co2HistoricalRecord;
import com.uni.co2ms.model.Co2Record;
import com.uni.co2ms.model.Co2RecordFromCentralSensorSystemMockData;
import com.uni.co2ms.repository.Co2RecordsRepository;
import com.uni.co2ms.repository.HistoricalCo2RecordsRepository;
import com.uni.co2ms.service.Co2Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Co2ServiceImpl implements Co2Service {

	private static final Logger log = LoggerFactory.getLogger(Co2ServiceImpl.class);

	@Autowired
	Co2RecordsRepository co2RecordsRepository;
	@Autowired
	HistoricalCo2RecordsRepository historicalCo2RecordsRepository;
	@Autowired
	Co2RecordFromCentralSensorSystemMockData centralSensorServiceMockData;

	@Override
	public List<Co2Record> getAllCo2Records() {
		try {
			log.info("Fetching all records from Co2 Monitoring System");
			return co2RecordsRepository.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RecordNotException("Error occurred..");
		}

	}

	@Override
	public Co2Record getCo2RecordById(Long id) {
		try {
			log.info("Fetching all records from Co2 Monitoring System");
			Co2Record co2Record = co2RecordsRepository.findById(id).get();
			return co2Record;
		} catch (Exception e) {
			log.error("Error : " + e.getMessage());
			throw new RecordNotException("Record not found for given id");
		}
	}

	/**
	 * Scheduled service call to Central Co2 sensor system API , scheduled service
	 * calling to latest co2 records from all cities every 5 minute and update
	 * records in current co2records table and historical table in co2ms db
	 */
	@Override
	@Scheduled(fixedDelay = 300)
	public void updateCo2FromSensorSystem() {
		try {
			log.info("Updating latest record recieved by central sensors for respective city in Latest Co2 records Db");
			// Dummy service response
			List<Co2Record> serviceResponse = getCo2RecordFromCentralSensorSystem();
			for (Co2Record co2Record : serviceResponse) {
				updateLatestCo2Record(co2Record);
				addCo2RecordInhistoricalDb(co2Record);
			}
			log.info("updated latest Co2 Records in Current Co2 records table and Historical Co2 table");
		} catch (Exception e) {
			log.error("Error  : " + e.getMessage());
			throw new RecordNotException("Error occurred durring operation ,please refer logs");
		}
	}

	@Override
	public Co2Record getLatestCo2RecordByCity(String city) {
		try {
			log.info("Fetching all records from Co2 Monitoring System");
			Co2Record co2Record = co2RecordsRepository.findByCity(city);
			return co2Record;
		} catch (Exception e) {
			log.error("Error : " + e.getMessage());
			throw new RecordNotException("Record not found for given city");
		}
	}

	private void updateLatestCo2Record(Co2Record co2Record) {
		try {
			log.info("Updating latest record recieved by central sensors for respective city in Latest Co2 records Db");
			Co2Record existingRecord = co2RecordsRepository.findByCity(co2Record.getCity());
			existingRecord.setCo2Level(co2Record.getCo2Level());
			existingRecord.setRecorDateTime(co2Record.getRecorDateTime());
			Co2Record updatedRecord = co2RecordsRepository.save(existingRecord);
			log.info("updated Record latest co2 record for City : " + updatedRecord.getCity());
		} catch (Exception e) {
			log.error("Error  : " + e.getMessage());
			throw new RecordNotException("Error occurred durring updation ,please refer logs");
		}
	}

	private void addCo2RecordInhistoricalDb(Co2Record co2Record) {
		Co2HistoricalRecord co2HistoricalRecord = new Co2HistoricalRecord(co2Record.getCity(), co2Record.getCo2Level(),
				co2Record.getRecorDateTime());
		try {
			log.info("Adding latest record recieved by central sensors for respective city in Historical Db");
			Co2HistoricalRecord newCo2HistoricalRecord = historicalCo2RecordsRepository.save(co2HistoricalRecord);
			log.info("Added new Record in historical co2 db for City : " + newCo2HistoricalRecord.getCity());
		} catch (Exception e) {
			log.error("Error  : " + e.getMessage());
			throw new RecordNotException(
					"Error occurred durring inserting new record in historical data ,please refer logs");
		}
	}

	/*
	 * Calling Central sensor system API , scheduled service calling for latest co2
	 * records (Dummy call)
	 */
	private List<Co2Record> getCo2RecordFromCentralSensorSystem() {
		// Dummy service response
		List<Co2Record> serviceResponse = centralSensorServiceMockData.getDummyCo2RecordFromCentralSensorSystem();
		return serviceResponse;
	}

}
