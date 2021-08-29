package com.satyam.myenergy.service;

import org.springframework.stereotype.Service;

import com.satyam.myenergy.model.PricePlan;
import com.satyam.myenergy.model.PricePlanComparisons;
@Service
public interface PlanpriceService {
	
  public PricePlan storePlanPrice( PricePlan pricePlan);
  
  public PricePlanComparisons getBestValue();
}
