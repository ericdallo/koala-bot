package br.com.koala.utils;

import java.util.Calendar;

import org.junit.Test;

public class CalendarUtilsTest {

	@Test
	public void test() {
		Calendar calendar = Calendar.getInstance();
		System.out.println(CalendarUtils.getDayFor(calendar, WeekOfMonth.SIXTH, DayOfWeek.MONDAY));
	}

}
