package com.satyam.myenergy;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.satyam.myenergy.model.ElectricityReadings;
import com.satyam.myenergy.model.PricePlan;
import com.satyam.myenergy.model.PricePlanComparisons;
import com.satyam.myenergy.model.Readings;

@Component
public class DataMock {
	
	
	
	public PricePlan preparePricePlan()
	{
		PricePlan pricePlan = new PricePlan();
		pricePlan.setPricePlanId("price-plan-3");
		
		PricePlanComparisons pricePlanComparisons = new PricePlanComparisons();
		pricePlanComparisons.setPlan_price(new BigDecimal(65.78133785680731809));
		pricePlan.setPricePlanComparisons(pricePlanComparisons);
		
		return pricePlan;
	}
	
	
	public List<PricePlan> getPlanpriceList() {
		
	List<PricePlan> pricePlanList = new ArrayList<PricePlan>(); 
	
	PricePlan pricePlan = new PricePlan();
	pricePlan.setPricePlanId("price-plan-3");
	
	PricePlanComparisons pricePlanComparisons = new PricePlanComparisons();
	pricePlanComparisons.setPlan_price(new BigDecimal(65.78133785680731809));
	pricePlan.setPricePlanComparisons(pricePlanComparisons);
	
	pricePlanList.add(pricePlan);
	
	return pricePlanList;
	
	
	}
	 
	
	public List<Readings> getReadingList() {
		
		   List<Readings>  readingList= new ArrayList<Readings>();
		   
		   Readings reading = new Readings();
		   reading.setSmartMeterId("smart-meter-0");
		   
		   ElectricityReadings electricityReadings = new ElectricityReadings();
		   electricityReadings.setReading( new BigDecimal( 0.0503));
		   
		   Date date= new Date(0);
		   long time = date.getTime();
		   Timestamp ts = new Timestamp(time);
		   electricityReadings.setTime(ts);
		   
		   reading.setElectricityReadings(electricityReadings);
		   
		   readingList.add(reading);
		   
		  return readingList;
		}
	
	public Readings getReadings()
	{
		  Readings reading = new Readings();
		   reading.setSmartMeterId("smart-meter-0");
		   
		   ElectricityReadings electricityReadings = new ElectricityReadings();
		   electricityReadings.setReading( new BigDecimal( 0.0503));
		   
		   Date date= new Date(0);
		   long time = date.getTime();
		   Timestamp ts = new Timestamp(time);
		   electricityReadings.setTime(ts);
		   
		   reading.setElectricityReadings(electricityReadings);
		return reading;
	}

}
