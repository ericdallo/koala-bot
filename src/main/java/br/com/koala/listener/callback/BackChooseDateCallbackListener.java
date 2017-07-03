package br.com.koala.listener.callback;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.request.EditMessageReplyMarkup;

import br.com.koala.keyboard.CalendarKeyboard;
import br.com.koala.utils.SimpleTimeKeyboard;

@Component
class BackChooseDateCallbackListener extends TimeCallbackListener {

	@Autowired
	BackChooseDateCallbackListener(TelegramBot bot) {
		super(bot);
	}

	@Override
	public void listen(CallbackQuery callback) {
		Long milis = Long.parseLong(callback.data().split("_")[1]);
		
		LocalDate date = LocalDateTime.ofInstant(Instant.ofEpochMilli(milis.longValue()), ZoneId.systemDefault()).toLocalDate();
		
		bot.execute(new EditMessageReplyMarkup(callback.message().chat().id(), callback.message().messageId(), "Qual a data do role então?")
						.replyMarkup(new CalendarKeyboard(date)));
	}

	@Override
	boolean timeMatch(String action) {
		return action.startsWith(SimpleTimeKeyboard.BACK);
	}

}
