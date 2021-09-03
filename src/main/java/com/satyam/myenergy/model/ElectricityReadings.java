package com.satyam.myenergy.model;

import java.math.BigDecimal;
import java.sql.Timestamp;



public class ElectricityReadings {
	
	
    private Timestamp time;
    
    private BigDecimal reading;
    
    public ElectricityReadings()
    {
    	System.out.println(" Hello ElectricityReadings bro");
    }

	

	public Timestamp getTime() {
		return time;
	}



	public void setTime(Timestamp time) {
		this.time = time;
	}



	public BigDecimal getReading() {
		return reading;
	}

	public void setReading(BigDecimal reading) {
		this.reading = reading;
	}

}
