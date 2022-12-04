package com.se.onlinemoviebooking.application.dto;

import java.util.ArrayList;
import java.util.Arrays;

public enum ShowRoom {
	SCREENX(1, "SCREEN-X", 40,
			"A1,A2,A3,A4,A5,A6,A7,A8,B1,B2,B3,B4,B5,B6,B7,B8,C1,C2,C3,C4,C5,C6,C7,C8,D1,D2,D3,D4,D5,D6,D7,D8,E1,E2,E3,E4,E5,E6,E7,E8"),
	MAXRELAX(2, "MAX-RELAX", 40,
			"A1,A2,A3,A4,A5,A6,A7,A8,B1,B2,B3,B4,B5,B6,B7,B8,C1,C2,C3,C4,C5,C6,C7,C8,D1,D2,D3,D4,D5,D6,D7,D8,E1,E2,E3,E4,E5,E6,E7,E8"),
	REAL3D(3, "REAL-3D", 40,
			"A1,A2,A3,A4,A5,A6,A7,A8,B1,B2,B3,B4,B5,B6,B7,B8,C1,C2,C3,C4,C5,C6,C7,C8,D1,D2,D3,D4,D5,D6,D7,D8,E1,E2,E3,E4,E5,E6,E7,E8"),
	SCREENPLAY(4, "SCREEN-PLAY", 40,
			"A1,A2,A3,A4,A5,A6,A7,A8,B1,B2,B3,B4,B5,B6,B7,B8,C1,C2,C3,C4,C5,C6,C7,C8,D1,D2,D3,D4,D5,D6,D7,D8,E1,E2,E3,E4,E5,E6,E7,E8");

	private Integer id;
	private String name;
	private Integer seats;
	private String seatsids;

	ShowRoom(Integer id, String name, Integer seats, String seatids) {
		this.name = name;
		this.id = id;
		this.seats = seats;
		this.seatsids = seatids;
	}

	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public Integer getSeats() {
		return this.seats;
	}

	public String getSeatIds() {
		return this.seatsids;
	}

	public ArrayList<String> getSeatIdsAsList() {
		ArrayList<String> allseats = new ArrayList<String>(Arrays.asList("A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8",
				"B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "D1",
				"D2", "D3", "D4", "D5", "D6", "D7", "D8", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8"));
		return allseats;
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
