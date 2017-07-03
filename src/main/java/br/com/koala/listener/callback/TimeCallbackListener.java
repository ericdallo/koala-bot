package br.com.koala.listener.callback;

import static br.com.koala.utils.SimpleTimeKeyboard.TIME_PREFIX;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.CallbackQuery;

abstract class TimeCallbackListener extends CallbackListener {

	TimeCallbackListener(TelegramBot bot) {
		super(bot);
	}
	
	@Override
	public boolean match(CallbackQuery callback) {
		return callback.data().startsWith(TIME_PREFIX) && timeMatch(callback.data().split(TIME_PREFIX)[1]);
	}

	abstract boolean timeMatch(String action);

}
