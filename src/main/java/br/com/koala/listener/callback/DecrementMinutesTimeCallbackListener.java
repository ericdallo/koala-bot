package br.com.koala.listener.callback;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.EditMessageReplyMarkup;

import br.com.koala.utils.SimpleTimeKeyboard;

@Component
class DecrementMinutesTimeCallbackListener extends TimeCallbackListener {

	@Autowired
	DecrementMinutesTimeCallbackListener(TelegramBot bot) {
		super(bot);
	}

	@Override
	public void listen(CallbackQuery callback) {
		Long milis = Long.parseLong(callback.data().split("_")[1]);
		
		long decrementedMilis = LocalDateTime.ofInstant(Instant.ofEpochMilli(milis.longValue()), ZoneId.systemDefault())
					 .minusMinutes(30)
					 .atZone(ZoneId.systemDefault())
					 .toInstant()
					 .toEpochMilli();
		
		Message message = callback.message();
		
		bot.execute(new EditMessageReplyMarkup(message.chat().id(), message.messageId())
						.replyMarkup(new SimpleTimeKeyboard(decrementedMilis)));
	}

	@Override
	boolean timeMatch(String action) {
		return action.startsWith(SimpleTimeKeyboard.DOWN_MINUTE);
	}
}
