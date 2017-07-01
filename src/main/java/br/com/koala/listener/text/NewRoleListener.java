package br.com.koala.listener.text;

import static br.com.koala.configuration.Command.NEW_ROLE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.SendMessage;

import br.com.koala.configuration.Command;
import br.com.koala.keyboard.CalendarKeyboard;

@Component
public class NewRoleListener extends TextListener {

	@Autowired
	NewRoleListener(TelegramBot bot) {
		super(bot);
	}

	@Override
	public SendMessage listen(Message message) {
		return new SendMessage(message.chat().id(), "Qual a data do role?")
					.replyMarkup(new CalendarKeyboard());
	}

	@Override
	public boolean match(Message message) {
		return Command.is(message.text(), NEW_ROLE);
	}

}
