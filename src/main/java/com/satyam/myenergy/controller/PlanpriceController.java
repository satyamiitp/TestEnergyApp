package com.satyam.myenergy.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.satyam.myenergy.model.PricePlan;
import com.satyam.myenergy.model.PricePlanComparisons;
import com.satyam.myenergy.service.PlanpriceService;

@RestController
public class PlanpriceController {
	
public static BigDecimal bestDeal;
	
public static List<PricePlan> pricePlanList = new ArrayList<PricePlan>();

@Autowired
PlanpriceService planpriceService;

@PostMapping(value="/pricePaln")
public String storePlanPrice(@RequestBody PricePlan pricePlan )
{
	
	planpriceService.storePlanPrice(pricePlan);
	
	return " Plan Price stored successfully";
}
	
@GetMapping(value="/comparision")
public PricePlanComparisons getBestDeal()
{
	
	return planpriceService.getBestValue();
}

}
