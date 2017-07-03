package br.com.koala.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;

public class SimpleTimeKeyboard extends InlineKeyboardMarkup {

	private static final long serialVersionUID = 1L;
	
	public static final String TIME_PREFIX = "/time-";
	public static final String UP_HOUR = "up-hour_";
	public static final String UP_MINUTE = "up-minute_";
	public static final String DOWN_HOUR = "down-hour_";
	public static final String DOWN_MINUTE = "down-minute_";
	public static final String BACK = "back_";
	public static final String CONFIRM = "confirm_";

	public SimpleTimeKeyboard(Long milis) {
		super(upKeys(milis), time(milis), downKeys(milis), backAndConfirm(milis));
	}


	private static InlineKeyboardButton[] upKeys(Long milis) {
		InlineKeyboardButton downHour = new InlineKeyboardButton("▲").callbackData(TIME_PREFIX + UP_HOUR + milis);
		InlineKeyboardButton downMinute = new InlineKeyboardButton("▲").callbackData(TIME_PREFIX + UP_MINUTE + milis);
		
		return new InlineKeyboardButton[] { downHour, downMinute};
	}
	
	private static InlineKeyboardButton[] time(Long milis) {
		LocalDateTime time = LocalDateTime.ofInstant(Instant.ofEpochMilli(milis.longValue()), ZoneId.systemDefault());
		
		InlineKeyboardButton hour = new InlineKeyboardButton(time.getHour() + "").callbackData(" ");
		InlineKeyboardButton minute = new InlineKeyboardButton(time.getMinute() + "").callbackData(" ");
		
		return new InlineKeyboardButton[] { hour, minute};
	}

	private static InlineKeyboardButton[] downKeys(Long milis) {
		InlineKeyboardButton downHour = new InlineKeyboardButton("▼").callbackData(TIME_PREFIX + DOWN_HOUR + milis);
		InlineKeyboardButton downMinute = new InlineKeyboardButton("▼").callbackData(TIME_PREFIX + DOWN_MINUTE + milis);
		
		return new InlineKeyboardButton[] { downHour, downMinute};
	}

	private static InlineKeyboardButton[] backAndConfirm(Long milis) {
		InlineKeyboardButton back = new InlineKeyboardButton("⇠ Escolher outra data").callbackData(TIME_PREFIX + BACK + milis);
		InlineKeyboardButton confirm = new InlineKeyboardButton("Confirmar ✔").callbackData(TIME_PREFIX + CONFIRM + milis);
		
		return new InlineKeyboardButton[] { back, confirm };
	}

}
