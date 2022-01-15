package com.uni.co2ms.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Co2RecordFromCentralSensorSystemMockData {

	public List<Co2Record> getDummyCo2RecordFromCentralSensorSystem(){
		List<Co2Record> co2RecordsFromSensorSystem=new ArrayList<>();
		Co2Record co2Record1=new Co2Record(5l,"barcelona","990",LocalDateTime.now());
		Co2Record co2Record2=new Co2Record(5l,"barcelona","990",LocalDateTime.now());
		Co2Record co2Record3=new Co2Record(5l,"barcelona","990",LocalDateTime.now());
		Co2Record co2Record4=new Co2Record(5l,"barcelona","990",LocalDateTime.now());
		co2RecordsFromSensorSystem.add(co2Record1);
		co2RecordsFromSensorSystem.add(co2Record2);
		co2RecordsFromSensorSystem.add(co2Record3);
		co2RecordsFromSensorSystem.add(co2Record4);
		return co2RecordsFromSensorSystem;
	}
}
