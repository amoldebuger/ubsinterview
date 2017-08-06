package com.ubs.opsit.interviews;

public class BerlinClockTimeConverter implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		
		try {
			return new BerlinClockTimeCalculator().getTime(aTime);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

}
