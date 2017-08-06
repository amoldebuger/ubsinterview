package com.ubs.opsit.interviews.enums;

public enum LAMP {

	RED_LAMP("R"), YELLOW_LAMP("Y"), OFF_LAMP("O");

	private String color;
		
	private LAMP(String color) {
			this.color=color;
	}
	
	public String getColor(){
		return color;
	}

	
}
