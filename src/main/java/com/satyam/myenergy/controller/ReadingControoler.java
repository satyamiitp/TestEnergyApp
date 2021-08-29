package com.satyam.myenergy.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.satyam.myenergy.model.ElectricityReadings;
import com.satyam.myenergy.model.Readings;
import com.satyam.myenergy.service.ReadingService;

@RestController

public class ReadingControoler {
	
	@Autowired
	ReadingService readingService;
	
	@PostMapping(value="/store")
	public String storeReading(@RequestBody Readings readings)
	{
		
		readingService.storeReading(readings);
		
		return " Reading is succesfully stored";
	}
	
	@GetMapping(value="/allreadings")
	public List<Readings> getAllReadings()
	{
		return readingService.getAllReadings();
		
	}
	
	@GetMapping(value="/oneReading/{smartId}")
	public ElectricityReadings getReading(@PathVariable String smartId  )
	{
		List<Readings> readingList1=readingService.getAllReadings().stream().filter(p->p.getSmartMeterId().equals(smartId)).collect(Collectors.toList());
		return readingList1.get(0).getElectricityReadings();
	}
	

	@GetMapping(value="/readings")
	public List<ElectricityReadings> getAllEReadings()
	{
		
	   return readingService.getAllReadings().stream().map(p->p.getElectricityReadings()).collect(Collectors.toList());
			 
	}
	

}
