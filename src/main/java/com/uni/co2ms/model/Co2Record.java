package com.uni.co2ms.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data

public class Co2Record {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique=true)
	private String city;

	private String co2Level;

	private LocalDateTime recorDateTime;

	public Co2Record() {
		super();
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

	public Co2Record(long id, String city, String co2Level, LocalDateTime recorDateTime) {
		super();
		this.id = id;
		this.city = city;
		this.co2Level = co2Level;
		this.recorDateTime = recorDateTime;
	}

}
