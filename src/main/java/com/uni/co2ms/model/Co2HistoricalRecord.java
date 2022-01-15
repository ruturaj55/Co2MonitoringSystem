package com.uni.co2ms.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Co2HistoricalRecord {

	@Id
	@GeneratedValue
	private long id;

	private String city;

	private String co2Level;

	private LocalDateTime recorDateTime;

	public Co2HistoricalRecord(String city2, String co2Level2, LocalDateTime recorDateTime2) {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCo2Level() {
		return co2Level;
	}

	public void setCo2Level(String co2Level) {
		this.co2Level = co2Level;
	}

	public LocalDateTime getRecorDateTime() {
		return recorDateTime;
	}

	public void setRecorDateTime(LocalDateTime recorDateTime) {
		this.recorDateTime = recorDateTime;
	}

}
