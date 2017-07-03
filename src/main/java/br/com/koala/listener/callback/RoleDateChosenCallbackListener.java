package br.com.koala.listener.callback;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.EditMessageText;

import br.com.koala.keyboard.CalendarKeyboard;
import br.com.koala.utils.SimpleTimeKeyboard;

@Component
class RoleDateChosenCallbackListener extends CallbackListener {

	@Autowired
	RoleDateChosenCallbackListener(TelegramBot bot) {
		super(bot);
	}

	@Override
	public void listen(CallbackQuery callback) {
		Long milis = Long.parseLong(callback.data().split("_")[1]);
		
		LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(milis.longValue()), ZoneId.systemDefault())
											  .plusHours(18);
		
		String chosenDate = dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Message message = callback.message();
		EditMessageText editedMessage = new EditMessageText(message.chat().id(), message.messageId(), "Escolha a hora do dia " + chosenDate)
						.replyMarkup(new SimpleTimeKeyboard(milis));
		
		bot.execute(editedMessage);
	}

	@Override
	public boolean match(CallbackQuery callback) {
		return callback.data().startsWith(CalendarKeyboard.CHOOSE_DATE_PREFIX);
	}

}
