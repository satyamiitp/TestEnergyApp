package com.satyam.myenergy.model;

import java.math.BigDecimal;

public class PricePlan {

	//change2

	private String  pricePlanId;
	
	private PricePlanComparisons pricePlanComparisons;
	
	public PricePlan()
	{
		System.out.println(" Hello price plan  bro");
	}

	public String getPricePlanId() {
		return pricePlanId;
	}

	public void setPricePlanId(String pricePlanId) {
		this.pricePlanId = pricePlanId;
	}

	public PricePlanComparisons getPricePlanComparisons() {
		return pricePlanComparisons;
	}

	public void setPricePlanComparisons(PricePlanComparisons pricePlanComparisons) {
		this.pricePlanComparisons = pricePlanComparisons;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
	
}
