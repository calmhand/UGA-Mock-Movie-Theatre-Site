package com.se.onlinemoviebooking.application.dto;

public enum Status {
	ACTIVE(1, "ACTIVE"), INACTIVE(2, "INACTIVE"), DELETE(3, "DELETE");

	private int id;
	private String name;

	Status(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getID() {
		return this.id;
	}

	public static Status getStatusByName(String status) {
		switch (status.trim().toUpperCase()) {
		case "ACTIVE":
			return Status.ACTIVE;
		case "INACTIVE":
			return Status.ACTIVE;
		case "DELETE":
			return Status.DELETE;
		default:
			return Status.INACTIVE;
		}
	}

	public static Status getStatusByID(int ID) {
		switch (ID) {
		case 1:
			return Status.ACTIVE;
		case 2:
			return Status.ACTIVE;
		case 3:
			return Status.DELETE;
		default:
			return Status.INACTIVE;
		}
	}
}
