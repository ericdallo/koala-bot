package br.com.koala.listener.callback;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.EditMessageReplyMarkup;

import br.com.koala.keyboard.CalendarKeyboard;

@Component
class ChangeCalendarCallbackListener extends CallbackListener {

	@Autowired
	ChangeCalendarCallbackListener(TelegramBot bot) {
		super(bot);
	}

	@Override
	public void listen(CallbackQuery callback) {
		Long milis = Long.parseLong(callback.data().split("_")[1]);
		
		LocalDate date = LocalDateTime.ofInstant(Instant.ofEpochMilli(milis.longValue()), ZoneId.systemDefault()).toLocalDate();
		
		Message message = callback.message();
		EditMessageReplyMarkup editedMessage = new EditMessageReplyMarkup(message.chat().id(), message.messageId(), message.text())
						.replyMarkup(new CalendarKeyboard(date));
		
		bot.execute(editedMessage);
	}

	@Override
	public boolean match(CallbackQuery callback) {
		return callback.data().startsWith("/calendar-back") || 
			   callback.data().startsWith("/calendar-next");
	}

}
