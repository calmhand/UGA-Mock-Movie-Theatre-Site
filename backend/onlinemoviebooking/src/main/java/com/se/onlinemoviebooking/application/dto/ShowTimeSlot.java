package com.se.onlinemoviebooking.application.dto;

public enum ShowTimeSlot {
	SHOW1(1,"09:00"),SHOW2(2,"13:00"),SHOW3(3,"18:00"),SHOW4(4,"22:00"); // HH:MM format
	
	
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
		case "09:00":
			return ShowTimeSlot.SHOW1;
		case "13:00":
			return ShowTimeSlot.SHOW2;
		case "18:00":
			return ShowTimeSlot.SHOW3;
		case "22:00":
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
