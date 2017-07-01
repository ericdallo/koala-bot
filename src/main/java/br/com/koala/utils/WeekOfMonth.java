package br.com.koala.utils;

public enum WeekOfMonth {
	
	FIRST(1),
	SECOND(2),
	THIRD(3),
	FOURTH(4),
	FIFTH(5),
	SIXTH(6),
	;
	
	private int weekNumber;
	
	private WeekOfMonth(int weekNumber) {
		this.weekNumber = weekNumber;
	}
	
	public int getWeekNumber() {
		return weekNumber;
	}
}
