package com.satyam.myenergy.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyam.myenergy.model.Readings;
import com.satyam.myenergy.repository.ReadingRepository;
import com.satyam.myenergy.service.ReadingService;

@Service
public class ReadingServiceImpl implements ReadingService {
	
	@Autowired
	ReadingRepository readingRepository;


	public Readings storeReading(Readings reading) {
		
		readingRepository.setReadingList(reading);
		return reading;
	}


	@Override
	public List<Readings> getAllReadings() {
		
		return readingRepository.getReadingList();
	}

}
