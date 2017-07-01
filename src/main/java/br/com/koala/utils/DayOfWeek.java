package br.com.koala.utils;

import static java.util.Arrays.stream;

public enum DayOfWeek {
    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7);

    private final int value;

    DayOfWeek(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

	public static DayOfWeek from(int value) {
		return stream(values())
			.filter(dayOfWeek -> dayOfWeek.getValue() == value)
			.findFirst()
			.orElseThrow(IllegalArgumentException::new)
			;
	}
}