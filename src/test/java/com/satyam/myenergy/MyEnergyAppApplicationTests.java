package com.satyam.myenergy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import com.satyam.myenergy.model.PricePlanComparisons;
import com.satyam.myenergy.repository.PlanpriceRepository;
import com.satyam.myenergy.repository.ReadingRepository;
import com.satyam.myenergy.serviceImpl.PlanpriceServiceImpl;
import com.satyam.myenergy.serviceImpl.ReadingServiceImpl;

@SpringBootTest
class MyEnergyAppApplicationTests {
	
	@Mock
	ReadingRepository readingRepository;
	
	@Mock
	PlanpriceRepository planpriceRepository;
	
	@InjectMocks
	PlanpriceServiceImpl planpriceServiceImpl;

	@InjectMocks
	ReadingServiceImpl readingServiceImpl;
	

	@Test
   public void getAllReadingsTest() 
	{
		DataMock dataMock = new DataMock();
		when(readingRepository.getReadingList()).thenReturn(dataMock.getReadingList());
		assertEquals("smart-meter-0", readingServiceImpl.getAllReadings().get(0).getSmartMeterId());
		assertEquals(new BigDecimal(0.0503),readingServiceImpl.getAllReadings().get(0).getElectricityReadings().getReading());
		assertNotNull(readingServiceImpl.getAllReadings().get(0).getElectricityReadings().getTime());
		assertNotNull(readingServiceImpl.getAllReadings());
	}
	
	
	
	@Test
	void storeReading() 
	{
		DataMock dataMock = new DataMock();
		assertEquals("smart-meter-0", readingServiceImpl.storeReading(dataMock.getReadings()).getSmartMeterId());
		assertEquals(new BigDecimal(0.0503),readingServiceImpl.storeReading(dataMock.getReadings()).getElectricityReadings().getReading());
		assertNotNull(readingServiceImpl.storeReading(dataMock.getReadings()).getElectricityReadings().getTime());
		assertNotNull(readingServiceImpl.storeReading(dataMock.getReadings()));
	
		
	}
	
	
	@Test
	void getBestDeal()
	{
		planpriceServiceImpl.bestDeal=new BigDecimal(65.78133785680731809);
		DataMock dataMock = new DataMock();
		when(planpriceRepository.getPricePlanList()).thenReturn(dataMock.getPlanpriceList());
		assertNotNull(planpriceServiceImpl.getBestValue());
		assertEquals(new BigDecimal(65.78133785680731809),planpriceServiceImpl.getBestValue().getPlan_price());
			
	}
	
	@Test
	 void storePlanPrice()
	 {
		DataMock dataMock = new DataMock();
		planpriceServiceImpl.bestDeal=new BigDecimal(65.78133785680731809);
		//anpriceServiceImpl.storePlanPrice(dataMock.preparePricePlan());
		assertNotNull(planpriceServiceImpl.storePlanPrice(dataMock.preparePricePlan()));
		assertEquals(new BigDecimal(65.78133785680731809),planpriceServiceImpl.storePlanPrice(dataMock.preparePricePlan()).getPricePlanComparisons().getPlan_price());
	 }
	
	@Test
	 void storePlanPriceNullCaseTest()
	 {
		DataMock dataMock = new DataMock();
		planpriceServiceImpl.bestDeal=null;
		assertNotNull(planpriceServiceImpl.storePlanPrice(dataMock.preparePricePlan()));
		assertEquals(new BigDecimal(65.78133785680731809),planpriceServiceImpl.storePlanPrice(dataMock.preparePricePlan()).getPricePlanComparisons().getPlan_price());
		
	 }
	 
	

	

}
