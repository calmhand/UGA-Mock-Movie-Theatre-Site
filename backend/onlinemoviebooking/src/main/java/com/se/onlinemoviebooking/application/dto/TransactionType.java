package com.se.onlinemoviebooking.application.dto;

public enum TransactionType {
	
	CARD(1, "CARD");

	private int id;
	private String name;

	TransactionType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getID() {
		return this.id;
	}

	public static TransactionType getStatusByName(String status) {
		switch (status.trim().toUpperCase()) {
		case "CARD":
			return TransactionType.CARD;
		default:
			return TransactionType.CARD;
		}
	}

	public static TransactionType getStatusByID(int ID) {
		switch (ID) {
		case 1:
			return TransactionType.CARD;
		default:
			return TransactionType.CARD;
		}
	}
	

	
}
