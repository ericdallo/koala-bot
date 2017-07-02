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

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;

import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;

public class CalendarKeyboard extends InlineKeyboardMarkup {

	private static final long serialVersionUID = 5354476177850625979L;

	public CalendarKeyboard(LocalDate date) {
		super(monthAndYear(date), daysOfWeek(), firstWeek(date), secondWeek(date), thirdWeek(date), fourthWeek(date), fifthWeek(date), sixthWeek(date), options(date));
	}

	private static InlineKeyboardButton[] monthAndYear(LocalDate date) {
		String month = date.getMonth().toString();
		int year = date.getYear();

		return new InlineKeyboardButton[] { new InlineKeyboardButton(month + " " + year).callbackData("/calendar-header_" + month + "/" + year) };
	}

	private static InlineKeyboardButton[] firstWeek(LocalDate localDate) {
		Calendar date = GregorianCalendar.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		
		InlineKeyboardButton sunday = button(dayInString(getDayFor(date, FIRST, SUNDAY)), calendarInString(getDayFor(date, FIRST, SUNDAY)));
		InlineKeyboardButton monday = button(dayInString(getDayFor(date, FIRST, MONDAY)), calendarInString(getDayFor(date, FIRST, MONDAY)));
		InlineKeyboardButton tuesday = button(dayInString(getDayFor(date, FIRST, TUESDAY)), calendarInString(getDayFor(date, FIRST, TUESDAY)));
		InlineKeyboardButton wednesday = button(dayInString(getDayFor(date, FIRST, WEDNESDAY)), calendarInString(getDayFor(date, FIRST, WEDNESDAY)));
		InlineKeyboardButton thursday = button(dayInString(getDayFor(date, FIRST, THURSDAY)), calendarInString(getDayFor(date, FIRST, THURSDAY)));
		InlineKeyboardButton friday = button(dayInString(getDayFor(date, FIRST, FRIDAY)), calendarInString(getDayFor(date, FIRST, FRIDAY)));
		InlineKeyboardButton saturday = button(dayInString(getDayFor(date, FIRST, SATURDAY)), calendarInString(getDayFor(date, FIRST, SATURDAY)));
		
		return new InlineKeyboardButton[] { sunday, monday, tuesday, wednesday, thursday, friday, saturday };
	}

	private static InlineKeyboardButton[] secondWeek(LocalDate localDate) {
		Calendar date = GregorianCalendar.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		
		InlineKeyboardButton sunday = button(dayInString(getDayFor(date, SECOND, SUNDAY)), calendarInString(getDayFor(date, SECOND, SUNDAY)));
		InlineKeyboardButton monday = button(dayInString(getDayFor(date, SECOND, MONDAY)), calendarInString(getDayFor(date, SECOND, MONDAY)));
		InlineKeyboardButton tuesday = button(dayInString(getDayFor(date, SECOND, TUESDAY)), calendarInString(getDayFor(date, SECOND, TUESDAY)));
		InlineKeyboardButton wednesday = button(dayInString(getDayFor(date, SECOND, WEDNESDAY)), calendarInString(getDayFor(date, SECOND, WEDNESDAY)));
		InlineKeyboardButton thursday = button(dayInString(getDayFor(date, SECOND, THURSDAY)), calendarInString(getDayFor(date, SECOND, THURSDAY)));
		InlineKeyboardButton friday = button(dayInString(getDayFor(date, SECOND, FRIDAY)), calendarInString(getDayFor(date, SECOND, FRIDAY)));
		InlineKeyboardButton saturday = button(dayInString(getDayFor(date, SECOND, SATURDAY)), calendarInString(getDayFor(date, SECOND, SATURDAY)));
		
		return new InlineKeyboardButton[] { sunday, monday, tuesday, wednesday, thursday, friday, saturday };
	}

	private static InlineKeyboardButton[] thirdWeek(LocalDate localDate) {
		Calendar date = GregorianCalendar.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		
		InlineKeyboardButton sunday = button(dayInString(getDayFor(date, THIRD, SUNDAY)), calendarInString(getDayFor(date, THIRD, SUNDAY)));
		InlineKeyboardButton monday = button(dayInString(getDayFor(date, THIRD, MONDAY)), calendarInString(getDayFor(date, THIRD, MONDAY)));
		InlineKeyboardButton tuesday = button(dayInString(getDayFor(date, THIRD, TUESDAY)), calendarInString(getDayFor(date, THIRD, TUESDAY)));
		InlineKeyboardButton wednesday = button(dayInString(getDayFor(date, THIRD, WEDNESDAY)), calendarInString(getDayFor(date, THIRD, WEDNESDAY)));
		InlineKeyboardButton thursday = button(dayInString(getDayFor(date, THIRD, THURSDAY)), calendarInString(getDayFor(date, THIRD, THURSDAY)));
		InlineKeyboardButton friday = button(dayInString(getDayFor(date, THIRD, FRIDAY)), calendarInString(getDayFor(date, THIRD, FRIDAY)));
		InlineKeyboardButton saturday = button(dayInString(getDayFor(date, THIRD, SATURDAY)), calendarInString(getDayFor(date, THIRD, SATURDAY)));
		
		return new InlineKeyboardButton[] { sunday, monday, tuesday, wednesday, thursday, friday, saturday };
	}

	private static InlineKeyboardButton[] fourthWeek(LocalDate localDate) {
		Calendar date = GregorianCalendar.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		
		InlineKeyboardButton sunday = button(dayInString(getDayFor(date, FOURTH, SUNDAY)), calendarInString(getDayFor(date, FOURTH, SUNDAY)));
		InlineKeyboardButton monday = button(dayInString(getDayFor(date, FOURTH, MONDAY)), calendarInString(getDayFor(date, FOURTH, MONDAY)));
		InlineKeyboardButton tuesday = button(dayInString(getDayFor(date, FOURTH, TUESDAY)), calendarInString(getDayFor(date, FOURTH, TUESDAY)));
		InlineKeyboardButton wednesday = button(dayInString(getDayFor(date, FOURTH, WEDNESDAY)), calendarInString(getDayFor(date, FOURTH, WEDNESDAY)));
		InlineKeyboardButton thursday = button(dayInString(getDayFor(date, FOURTH, THURSDAY)), calendarInString(getDayFor(date, FOURTH, THURSDAY)));
		InlineKeyboardButton friday = button(dayInString(getDayFor(date, FOURTH, FRIDAY)), calendarInString(getDayFor(date, FOURTH, FRIDAY)));
		InlineKeyboardButton saturday = button(dayInString(getDayFor(date, FOURTH, SATURDAY)), calendarInString(getDayFor(date, FOURTH, SATURDAY)));
		
		return new InlineKeyboardButton[] { sunday, monday, tuesday, wednesday, thursday, friday, saturday };
	}

	private static InlineKeyboardButton[] fifthWeek(LocalDate localDate) {
		Calendar date = GregorianCalendar.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		
		InlineKeyboardButton sunday = button(dayInString(getDayFor(date, FIFTH, SUNDAY)), calendarInString(getDayFor(date, FIFTH, SUNDAY)));
		InlineKeyboardButton monday = button(dayInString(getDayFor(date, FIFTH, MONDAY)), calendarInString(getDayFor(date, FIFTH, MONDAY)));
		InlineKeyboardButton tuesday = button(dayInString(getDayFor(date, FIFTH, TUESDAY)), calendarInString(getDayFor(date, FIFTH, TUESDAY)));
		InlineKeyboardButton wednesday = button(dayInString(getDayFor(date, FIFTH, WEDNESDAY)), calendarInString(getDayFor(date, FIFTH, WEDNESDAY)));
		InlineKeyboardButton thursday = button(dayInString(getDayFor(date, FIFTH, THURSDAY)), calendarInString(getDayFor(date, FIFTH, THURSDAY)));
		InlineKeyboardButton friday = button(dayInString(getDayFor(date, FIFTH, FRIDAY)), calendarInString(getDayFor(date, FIFTH, FRIDAY)));
		InlineKeyboardButton saturday = button(dayInString(getDayFor(date, FIFTH, SATURDAY)), calendarInString(getDayFor(date, FIFTH, SATURDAY)));
		
		return new InlineKeyboardButton[] { sunday, monday, tuesday, wednesday, thursday, friday, saturday };
	}

	private static InlineKeyboardButton[] sixthWeek(LocalDate localDate) {
		Calendar date = GregorianCalendar.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		
		InlineKeyboardButton sunday = button(dayInString(getDayFor(date, SIXTH, SUNDAY)), calendarInString(getDayFor(date, SIXTH, SUNDAY)));
		InlineKeyboardButton monday = button(dayInString(getDayFor(date, SIXTH, MONDAY)), calendarInString(getDayFor(date, SIXTH, MONDAY)));
		InlineKeyboardButton tuesday = button(dayInString(getDayFor(date, SIXTH, TUESDAY)), calendarInString(getDayFor(date, SIXTH, TUESDAY)));
		InlineKeyboardButton wednesday = button(dayInString(getDayFor(date, SIXTH, WEDNESDAY)), calendarInString(getDayFor(date, SIXTH, WEDNESDAY)));
		InlineKeyboardButton thursday = button(dayInString(getDayFor(date, SIXTH, THURSDAY)), calendarInString(getDayFor(date, SIXTH, THURSDAY)));
		InlineKeyboardButton friday = button(dayInString(getDayFor(date, SIXTH, FRIDAY)), calendarInString(getDayFor(date, SIXTH, FRIDAY)));
		InlineKeyboardButton saturday = button(dayInString(getDayFor(date, SIXTH, SATURDAY)), calendarInString(getDayFor(date, SIXTH, SATURDAY)));
		
		return new InlineKeyboardButton[] { sunday, monday, tuesday, wednesday, thursday, friday, saturday };
	}

	private static InlineKeyboardButton[] daysOfWeek() {
		InlineKeyboardButton sunday = button("S", "/calendar-S");
		InlineKeyboardButton monday = button("M", "/calendar-M");
		InlineKeyboardButton tuesday = button("T", "/calendar-T");
		InlineKeyboardButton wednesday = button("W", "/calendar-W");
		InlineKeyboardButton thursday = button("T", "/calendar-T");
		InlineKeyboardButton friday = button("F", "/calendar-F");
		InlineKeyboardButton saturday = button("S", "/calendar-S");

		return new InlineKeyboardButton[] { sunday, monday, tuesday, wednesday, thursday, friday, saturday };
	}

	private static InlineKeyboardButton[] options(LocalDate date) {
		long backMilis = date.minusMonths(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		long nextMilis = date.plusMonths(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		
		InlineKeyboardButton back = button("<", "/calendar-back_" + backMilis);
		InlineKeyboardButton nothing = button(" ", "/calendar-nothing");
		InlineKeyboardButton next = button(">", "/calendar-next_" + nextMilis);

		return new InlineKeyboardButton[] { back, nothing, next };
	}
	
	private static String dayInString(Optional<GregorianCalendar> calendar) {
		return calendar.map(c -> c.get(DAY_OF_MONTH) + "")
					   .orElse(" ");
	}
	
	private static String calendarInString(Optional<GregorianCalendar> calendar) {
		return calendar.map(c -> "/calendar-choose_" + c.getTimeInMillis())
					   .orElse(" ");
	}

	private static InlineKeyboardButton button(String text, String callback) {
		return new InlineKeyboardButton(text).callbackData(callback);
	}
	
}
