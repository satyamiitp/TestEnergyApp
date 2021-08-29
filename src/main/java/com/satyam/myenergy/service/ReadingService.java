package com.satyam.myenergy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.satyam.myenergy.model.Readings;

@Service
public interface ReadingService {
	
	public Readings storeReading( Readings reading);
	
	public List<Readings> getAllReadings( );

}
