package com.satyam.myenergy.serviceImpl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyam.myenergy.model.PricePlan;
import com.satyam.myenergy.model.PricePlanComparisons;
import com.satyam.myenergy.repository.PlanpriceRepository;
import com.satyam.myenergy.service.PlanpriceService;

@Service
public class PlanpriceServiceImpl implements PlanpriceService {
	
	public static BigDecimal bestDeal;
	
	@Autowired
	PlanpriceRepository planpriceRepository;

	public  BigDecimal getBestDeal() {
		
		return bestDeal;
	}

	public  void setBestDeal(BigDecimal bestDeal) {
		
		PlanpriceServiceImpl.bestDeal = bestDeal;
	}

	@Override
	public PricePlan storePlanPrice(PricePlan pricePlan) {
		
		if(bestDeal!=null )
		{
			if( bestDeal.compareTo(pricePlan.getPricePlanComparisons().getPlan_price())>0)
			
			  bestDeal=pricePlan.getPricePlanComparisons().getPlan_price();
			
		}
		else
		{
			bestDeal=pricePlan.getPricePlanComparisons().getPlan_price();
		}
		
		planpriceRepository.pricePlanList.add(pricePlan);
		
		return pricePlan;
		
	}

	@Override
	public PricePlanComparisons getBestValue() {
		
		PricePlanComparisons priceplancomp = null;
		
		for(PricePlan p:planpriceRepository.getPricePlanList())
		{
			if(p.getPricePlanComparisons().getPlan_price().compareTo(bestDeal)==0)
			{
				priceplancomp=p.getPricePlanComparisons();
			}
		}
		
		return priceplancomp;
	}
	
	

}
