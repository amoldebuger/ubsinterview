package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ubs.opsit.interviews.enums.LAMP;

public class BerlinClockTimeCalculatorTest {

	BerlinClockTimeCalculator testTimeCalc= new BerlinClockTimeCalculator();
	
	@Test
	public void testGetLampRow() {
		assertEquals("OOO",testTimeCalc.getLampRow(0, 3, LAMP.OFF_LAMP));
		assertEquals("YYO",testTimeCalc.getLampRow(2, 3, LAMP.YELLOW_LAMP));
		assertEquals("RRO",testTimeCalc.getLampRow(2, 3, LAMP.RED_LAMP));
	}
	
	@Test
	public void testGetSeconds(){
		assertEquals("O", testTimeCalc.getSeconds(1));
		assertEquals("Y", testTimeCalc.getSeconds(2));
	}

	@Test
	public void testGetMin_1() {
		assertEquals("OOOOOOOOOOO", testTimeCalc.getMin_1(0));
		assertEquals("YOOOOOOOOOO", testTimeCalc.getMin_1(5));
		assertEquals("YYOOOOOOOOO", testTimeCalc.getMin_1(10));
		assertEquals("YYROOOOOOOO", testTimeCalc.getMin_1(15));
		assertEquals("YYRYOOOOOOO", testTimeCalc.getMin_1(20));
		assertEquals("YYRYYOOOOOO", testTimeCalc.getMin_1(25));
		assertEquals("YYRYYROOOOO", testTimeCalc.getMin_1(30));
		assertEquals("YYRYYRYOOOO", testTimeCalc.getMin_1(35));
		assertEquals("YYRYYRYYOOO", testTimeCalc.getMin_1(40));
		assertEquals("YYRYYRYYROO", testTimeCalc.getMin_1(45));
		assertEquals("YYRYYRYYRYO", testTimeCalc.getMin_1(50));
		assertEquals("YYRYYRYYRYY", testTimeCalc.getMin_1(55));
	}

	@Test
	public void testGetMin_2() {
		
		
		assertEquals("OOOO", testTimeCalc.getMin_2(0));
		assertEquals("YOOO", testTimeCalc.getMin_2(1));
		assertEquals("YYOO", testTimeCalc.getMin_2(2));
		assertEquals("YYYO", testTimeCalc.getMin_2(3));
		assertEquals("YYYY", testTimeCalc.getMin_2(4));
	}

	@Test
	public void testGetHour_1() {
		assertEquals("OOOO", testTimeCalc.getHour_1(0));
		assertEquals("ROOO", testTimeCalc.getHour_1(5));
		assertEquals("RROO", testTimeCalc.getHour_1(10));
		assertEquals("RRRO", testTimeCalc.getHour_1(15));
		assertEquals("RRRR", testTimeCalc.getHour_1(20));
		
	}

	@Test
	public void testGetHour_2() {
		assertEquals("OOOO", testTimeCalc.getHour_2(0));
		assertEquals("ROOO", testTimeCalc.getHour_2(1));
		assertEquals("RROO", testTimeCalc.getHour_2(2));
		assertEquals("RRRO", testTimeCalc.getHour_2(3));
		assertEquals("RRRR", testTimeCalc.getHour_2(4));
	}

	@Test
	public void testIsTimeValid() throws Exception {
	
		assertTrue(testTimeCalc.isTimeValid(0, 20, 20)); 
		assertFalse(testTimeCalc.isTimeValid(25, 20, 20)); 
		assertFalse(testTimeCalc.isTimeValid(0, 62, 20)); 
		assertFalse(testTimeCalc.isTimeValid(0, 20, 62)); 
		
	}
	

}
