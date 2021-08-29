package com.satyam.myenergy.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.satyam.myenergy.model.PricePlan;

@Repository
public class PlanpriceRepository {
	
	public static List<PricePlan> pricePlanList = new ArrayList<PricePlan>();

	public  List<PricePlan> getPricePlanList() {
		
		return pricePlanList;
	}

	public  void setPricePlanList(PricePlan pricePlan) {
		PlanpriceRepository.pricePlanList.add(pricePlan);
	}
	
	

}
