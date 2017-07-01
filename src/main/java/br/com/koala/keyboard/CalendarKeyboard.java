package br.com.koala.keyboard;

import static br.com.koala.utils.CalendarUtils.getDayFor;
import static br.com.koala.utils.DayOfWeek.FRIDAY;
import static br.com.koala.utils.DayOfWeek.MONDAY;
import static br.com.koala.utils.DayOfWeek.SATURDAY;
import static br.com.koala.utils.DayOfWeek.SUNDAY;
import static br.com.koala.utils.DayOfWeek.THURSDAY;
import static br.com.koala.utils.DayOfWeek.TUESDAY;
import static br.com.koala.utils.DayOfWeek.WEDNESDAY;
import static br.com.koala.utils.WeekOfMonth.FIFTH;
import static br.com.koala.utils.WeekOfMonth.FIRST;
import static br.com.koala.utils.WeekOfMonth.FOURTH;
import static br.com.koala.utils.WeekOfMonth.SECOND;
import static br.com.koala.utils.WeekOfMonth.SIXTH;
import static br.com.koala.utils.WeekOfMonth.THIRD;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_YEAR;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;

import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;

public class CalendarKeyboard extends InlineKeyboardMarkup {

	private static final long serialVersionUID = 5354476177850625979L;

	public CalendarKeyboard() {
		super(monthAndYear(), daysOfWeek(), firstWeek(), secondWeek(), thirdWeek(), fourthWeek(), fifthWeek(), sixthWeek(), options());
	}

	private static InlineKeyboardButton[] monthAndYear() {
		LocalDate now = LocalDate.now();

		String month = now.getMonth().toString();
		int year = now.getYear();

		return new InlineKeyboardButton[] { new InlineKeyboardButton(month + " " + year).callbackData(month + "/" + year) };
	}

	private static InlineKeyboardButton[] firstWeek() {
		Calendar now = Calendar.getInstance();
		
		InlineKeyboardButton sunday = button(dayInString(getDayFor(now, FIRST, SUNDAY)), calendarInString(getDayFor(now, FIRST, SUNDAY)));
		InlineKeyboardButton monday = button(dayInString(getDayFor(now, FIRST, MONDAY)), calendarInString(getDayFor(now, FIRST, MONDAY)));
		InlineKeyboardButton tuesday = button(dayInString(getDayFor(now, FIRST, TUESDAY)), calendarInString(getDayFor(now, FIRST, TUESDAY)));
		InlineKeyboardButton wednesday = button(dayInString(getDayFor(now, FIRST, WEDNESDAY)), calendarInString(getDayFor(now, FIRST, WEDNESDAY)));
		InlineKeyboardButton thursday = button(dayInString(getDayFor(now, FIRST, THURSDAY)), calendarInString(getDayFor(now, FIRST, THURSDAY)));
		InlineKeyboardButton friday = button(dayInString(getDayFor(now, FIRST, FRIDAY)), calendarInString(getDayFor(now, FIRST, FRIDAY)));
		InlineKeyboardButton saturday = button(dayInString(getDayFor(now, FIRST, SATURDAY)), calendarInString(getDayFor(now, FIRST, SATURDAY)));
		
		return new InlineKeyboardButton[] { sunday, monday, tuesday, wednesday, thursday, friday, saturday };
	}

	private static InlineKeyboardButton[] secondWeek() {
		Calendar now = Calendar.getInstance();
		
		InlineKeyboardButton sunday = button(dayInString(getDayFor(now, SECOND, SUNDAY)), calendarInString(getDayFor(now, SECOND, SUNDAY)));
		InlineKeyboardButton monday = button(dayInString(getDayFor(now, SECOND, MONDAY)), calendarInString(getDayFor(now, SECOND, MONDAY)));
		InlineKeyboardButton tuesday = button(dayInString(getDayFor(now, SECOND, TUESDAY)), calendarInString(getDayFor(now, SECOND, TUESDAY)));
		InlineKeyboardButton wednesday = button(dayInString(getDayFor(now, SECOND, WEDNESDAY)), calendarInString(getDayFor(now, SECOND, WEDNESDAY)));
		InlineKeyboardButton thursday = button(dayInString(getDayFor(now, SECOND, THURSDAY)), calendarInString(getDayFor(now, SECOND, THURSDAY)));
		InlineKeyboardButton friday = button(dayInString(getDayFor(now, SECOND, FRIDAY)), calendarInString(getDayFor(now, SECOND, FRIDAY)));
		InlineKeyboardButton saturday = button(dayInString(getDayFor(now, SECOND, SATURDAY)), calendarInString(getDayFor(now, SECOND, SATURDAY)));
		
		return new InlineKeyboardButton[] { sunday, monday, tuesday, wednesday, thursday, friday, saturday };
	}

	private static InlineKeyboardButton[] thirdWeek() {
		Calendar now = Calendar.getInstance();
		
		InlineKeyboardButton sunday = button(dayInString(getDayFor(now, THIRD, SUNDAY)), calendarInString(getDayFor(now, THIRD, SUNDAY)));
		InlineKeyboardButton monday = button(dayInString(getDayFor(now, THIRD, MONDAY)), calendarInString(getDayFor(now, THIRD, MONDAY)));
		InlineKeyboardButton tuesday = button(dayInString(getDayFor(now, THIRD, TUESDAY)), calendarInString(getDayFor(now, THIRD, TUESDAY)));
		InlineKeyboardButton wednesday = button(dayInString(getDayFor(now, THIRD, WEDNESDAY)), calendarInString(getDayFor(now, THIRD, WEDNESDAY)));
		InlineKeyboardButton thursday = button(dayInString(getDayFor(now, THIRD, THURSDAY)), calendarInString(getDayFor(now, THIRD, THURSDAY)));
		InlineKeyboardButton friday = button(dayInString(getDayFor(now, THIRD, FRIDAY)), calendarInString(getDayFor(now, THIRD, FRIDAY)));
		InlineKeyboardButton saturday = button(dayInString(getDayFor(now, THIRD, SATURDAY)), calendarInString(getDayFor(now, THIRD, SATURDAY)));
		
		return new InlineKeyboardButton[] { sunday, monday, tuesday, wednesday, thursday, friday, saturday };
	}

	private static InlineKeyboardButton[] fourthWeek() {
		Calendar now = Calendar.getInstance();
		
		InlineKeyboardButton sunday = button(dayInString(getDayFor(now, FOURTH, SUNDAY)), calendarInString(getDayFor(now, FOURTH, SUNDAY)));
		InlineKeyboardButton monday = button(dayInString(getDayFor(now, FOURTH, MONDAY)), calendarInString(getDayFor(now, FOURTH, MONDAY)));
		InlineKeyboardButton tuesday = button(dayInString(getDayFor(now, FOURTH, TUESDAY)), calendarInString(getDayFor(now, FOURTH, TUESDAY)));
		InlineKeyboardButton wednesday = button(dayInString(getDayFor(now, FOURTH, WEDNESDAY)), calendarInString(getDayFor(now, FOURTH, WEDNESDAY)));
		InlineKeyboardButton thursday = button(dayInString(getDayFor(now, FOURTH, THURSDAY)), calendarInString(getDayFor(now, FOURTH, THURSDAY)));
		InlineKeyboardButton friday = button(dayInString(getDayFor(now, FOURTH, FRIDAY)), calendarInString(getDayFor(now, FOURTH, FRIDAY)));
		InlineKeyboardButton saturday = button(dayInString(getDayFor(now, FOURTH, SATURDAY)), calendarInString(getDayFor(now, FOURTH, SATURDAY)));
		
		return new InlineKeyboardButton[] { sunday, monday, tuesday, wednesday, thursday, friday, saturday };
	}

	private static InlineKeyboardButton[] fifthWeek() {
		Calendar now = Calendar.getInstance();
		
		InlineKeyboardButton sunday = button(dayInString(getDayFor(now, FIFTH, SUNDAY)), calendarInString(getDayFor(now, FIFTH, SUNDAY)));
		InlineKeyboardButton monday = button(dayInString(getDayFor(now, FIFTH, MONDAY)), calendarInString(getDayFor(now, FIFTH, MONDAY)));
		InlineKeyboardButton tuesday = button(dayInString(getDayFor(now, FIFTH, TUESDAY)), calendarInString(getDayFor(now, FIFTH, TUESDAY)));
		InlineKeyboardButton wednesday = button(dayInString(getDayFor(now, FIFTH, WEDNESDAY)), calendarInString(getDayFor(now, FIFTH, WEDNESDAY)));
		InlineKeyboardButton thursday = button(dayInString(getDayFor(now, FIFTH, THURSDAY)), calendarInString(getDayFor(now, FIFTH, THURSDAY)));
		InlineKeyboardButton friday = button(dayInString(getDayFor(now, FIFTH, FRIDAY)), calendarInString(getDayFor(now, FIFTH, FRIDAY)));
		InlineKeyboardButton saturday = button(dayInString(getDayFor(now, FIFTH, SATURDAY)), calendarInString(getDayFor(now, FIFTH, SATURDAY)));
		
		return new InlineKeyboardButton[] { sunday, monday, tuesday, wednesday, thursday, friday, saturday };
	}

	private static InlineKeyboardButton[] sixthWeek() {
		Calendar now = Calendar.getInstance();
		
		InlineKeyboardButton sunday = button(dayInString(getDayFor(now, SIXTH, SUNDAY)), calendarInString(getDayFor(now, SIXTH, SUNDAY)));
		InlineKeyboardButton monday = button(dayInString(getDayFor(now, SIXTH, MONDAY)), calendarInString(getDayFor(now, SIXTH, MONDAY)));
		InlineKeyboardButton tuesday = button(dayInString(getDayFor(now, SIXTH, TUESDAY)), calendarInString(getDayFor(now, SIXTH, TUESDAY)));
		InlineKeyboardButton wednesday = button(dayInString(getDayFor(now, SIXTH, WEDNESDAY)), calendarInString(getDayFor(now, SIXTH, WEDNESDAY)));
		InlineKeyboardButton thursday = button(dayInString(getDayFor(now, SIXTH, THURSDAY)), calendarInString(getDayFor(now, SIXTH, THURSDAY)));
		InlineKeyboardButton friday = button(dayInString(getDayFor(now, SIXTH, FRIDAY)), calendarInString(getDayFor(now, SIXTH, FRIDAY)));
		InlineKeyboardButton saturday = button(dayInString(getDayFor(now, SIXTH, SATURDAY)), calendarInString(getDayFor(now, SIXTH, SATURDAY)));
		
		return new InlineKeyboardButton[] { sunday, monday, tuesday, wednesday, thursday, friday, saturday };
	}

	private static InlineKeyboardButton[] daysOfWeek() {
		InlineKeyboardButton sunday = button("S", "S");
		InlineKeyboardButton monday = button("M", "M");
		InlineKeyboardButton tuesday = button("T", "T");
		InlineKeyboardButton wednesday = button("W", "W");
		InlineKeyboardButton thursday = button("T", "T");
		InlineKeyboardButton friday = button("F", "F");
		InlineKeyboardButton saturday = button("S", "S");

		return new InlineKeyboardButton[] { sunday, monday, tuesday, wednesday, thursday, friday, saturday };
	}

	private static InlineKeyboardButton[] options() {
		InlineKeyboardButton back = button("<", "/calendar-back");
		InlineKeyboardButton nothing = button(" ", "/nothing");
		InlineKeyboardButton next = button(">", "/calendar-next");

		return new InlineKeyboardButton[] { back, nothing, next };
	}
	
	private static String dayInString(Optional<GregorianCalendar> calendar) {
		return calendar.map(c -> c.get(DAY_OF_MONTH) + "")
					   .orElse(" ");
	}
	
	private static String calendarInString(Optional<GregorianCalendar> calendar) {
		return calendar.map(c -> c.getTimeInMillis() + "")
					   .orElse(" ");
	}

	private static InlineKeyboardButton button(String text, String callback) {
		return new InlineKeyboardButton(text).callbackData(callback);
	}
	
}
