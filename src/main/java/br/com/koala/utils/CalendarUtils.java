package br.com.koala.utils;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.WEEK_OF_MONTH;
import static java.util.Calendar.YEAR;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CalendarUtils {

	public static Optional<GregorianCalendar> getDayFor(Calendar calendar, WeekOfMonth week, DayOfWeek dayOfWeek) {

		int daysOfCurrentMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		Map<Integer, DayOfWeek> days = new HashMap<>();
		for (int i = 1; i <= daysOfCurrentMonth; i++) {
			GregorianCalendar c = new GregorianCalendar(calendar.get(YEAR), calendar.get(MONTH), i);
		
			if  (week.getWeekNumber() == c.get(WEEK_OF_MONTH)) {
				days.put(c.get(DAY_OF_MONTH), DayOfWeek.from(c.get(DAY_OF_WEEK)));
			}
		}

		return days.entrySet().stream()
				   .filter(dayWithWeek -> dayWithWeek.getValue().getValue() == dayOfWeek.getValue())
				   .map(dayWithWeek -> new GregorianCalendar(calendar.get(YEAR), calendar.get(MONTH), dayWithWeek.getKey()))
				   .findFirst();
	}

}
