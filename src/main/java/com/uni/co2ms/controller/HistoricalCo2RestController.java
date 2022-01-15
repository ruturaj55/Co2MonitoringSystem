package com.uni.co2ms.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uni.co2ms.model.Co2HistoricalRecord;
import com.uni.co2ms.service.Co2HistoricalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class HistoricalCo2RestController {

	private Co2HistoricalService co2HistoricalService;

	@GetMapping("/historical-co2records")
	public ResponseEntity<List<Co2HistoricalRecord>> getAllCo2Records() {
		return ResponseEntity.ok(co2HistoricalService.getAllHistoricalCo2Records());
	}

	@GetMapping("/historical-co2records/{id}")
	public ResponseEntity<Co2HistoricalRecord> getCo2RecordsById(@PathVariable Long id) {
		return ResponseEntity.ok(co2HistoricalService.getHistoricalCo2RecordById(id));
	}

	@GetMapping("/historical-co2records-by-city-date")
	public ResponseEntity<List<Co2HistoricalRecord>> getAllHistoricalCo2RecordsByCityAndDate(
			@RequestParam("city") String city,
			@RequestParam("recorDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime recorDateTime) {
		return ResponseEntity.ok(co2HistoricalService.getHistoricalCo2RecordByCityAndDate(city, recorDateTime));
	}

	@PostMapping("/historical-co2records/add")
	public void addCo2RecordsinHistoricalDb(@RequestBody Co2HistoricalRecord co2HistoricalRecord) {
		co2HistoricalService.addCo2FromSensorSystemToHistoricalDb(co2HistoricalRecord);
	}

}
