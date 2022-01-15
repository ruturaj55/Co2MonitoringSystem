package com.uni.co2ms.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.uni.co2ms.model.Co2Record;
import com.uni.co2ms.service.Co2Service;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class Co2RestController {

	private Co2Service co2Service;

	@GetMapping("/co2records")
	public ResponseEntity<List<Co2Record>> getAllCo2Records() {
		return ResponseEntity.ok(co2Service.getAllCo2Records());
	}

	@GetMapping("/co2records/{id}")
	public ResponseEntity<Co2Record> getCo2RecordsById(@PathVariable Long id) {
		return ResponseEntity.ok(co2Service.getCo2RecordById(id));
	}

	@GetMapping("/co2records/{city}")
	public ResponseEntity<Co2Record> getAllCo2RecordsByCity(@PathVariable("city") String city) {
		// return ResponseEntity.ok(co2Service.getCo2RecordByCity(city));
		return null;
	}
}
