package com.se.onlinemoviebooking.application.dto;

public enum ShowRoom {
	SCREENX(1,"SCREEN-X"), MAXRELAX(2,"MAX-RELAX"), REAL3D(3,"REAL3D"), SCREENPLAY(4,"SCREEN-PLAY");
	
	private Integer id;
	private String name;
	
	ShowRoom(Integer id,String name) {
		this.name = name;
	}

	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	
	public static ShowRoom getShowRoomByName(String showRoom) {
		switch (showRoom.trim().toUpperCase()) {
		case "SCREEN-X":
			return ShowRoom.SCREENX;
		case "MAX-RELAX":
			return ShowRoom.MAXRELAX;
		case "REAL3D":
			return ShowRoom.REAL3D;
		case "SCREEN-PLAY":
			return ShowRoom.SCREENPLAY;
		default:
			return ShowRoom.SCREENX;
		}
	}

	public static ShowRoom getShowRoomByID(int id) {
		switch (id) {
		case 1:
			return ShowRoom.SCREENX;
		case 2:
			return ShowRoom.MAXRELAX;
		case 3:
			return ShowRoom.REAL3D;
		case 4:
			return ShowRoom.SCREENPLAY;
		default:
			return ShowRoom.SCREENX;
		}
	}
}
