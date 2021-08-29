package com.satyam.myenergy.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.satyam.myenergy.model.Readings;

@Repository
public class ReadingRepository {
	
	public static List<Readings>  readingList= new ArrayList<Readings>();

	public  List<Readings> getReadingList() {
		return readingList;
	}

	public  void setReadingList(Readings reading) {
		ReadingRepository.readingList.add(reading);
	}

}
