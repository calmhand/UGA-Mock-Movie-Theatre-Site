package com.se.onlinemoviebooking.application.dto;

public enum ShowTimeSlot {
	SHOW1(1,"9:00AM"),SHOW2(2,"1:00PM"),SHOW3(3,"6:00PM"),SHOW4(4,"10:00PM");
	
	
	private Integer id;
	private String name;
	
	ShowTimeSlot(Integer id,String name) {
		this.name = name;
	}

	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	
	public static ShowTimeSlot getShowRoomByName(String showTimeSlot) {
		switch (showTimeSlot.trim().toUpperCase()) {
		case "9:00AM":
			return ShowTimeSlot.SHOW1;
		case "1:00PM":
			return ShowTimeSlot.SHOW2;
		case "6:00PM":
			return ShowTimeSlot.SHOW3;
		case "10:00PM":
			return ShowTimeSlot.SHOW4;
		default:
			return null;
		}
	}

	public static ShowTimeSlot getShowRoomByID(int id) {
		switch (id) {
		case 1:
			return ShowTimeSlot.SHOW1;
		case 2:
			return ShowTimeSlot.SHOW2;
		case 3:
			return ShowTimeSlot.SHOW3;
		case 4:
			return ShowTimeSlot.SHOW4;
		default:
			return null;
		}
	}
	
}
