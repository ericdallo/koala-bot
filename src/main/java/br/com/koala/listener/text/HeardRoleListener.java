package br.com.koala.listener.text;

import static br.com.koala.configuration.Command.ROLES;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.SendMessage;

import br.com.koala.configuration.Command;

@Component
class HeardRoleListener extends TextListener {

	private static final String ROLE_REGEXP = "(.*)(R|r)(o|O)(l|L)(e|ê|E|Ê)(.*)";

	@Autowired
	HeardRoleListener(TelegramBot bot) {
		super(bot);
	}

	@Override
	public SendMessage listen(Message message) {
		return new SendMessage(message.chat().id(), "Ouvi rolê?");
	}

	@Override
	public boolean match(Message message) {
		String text = message.text();
		
		return !Command.is(text, ROLES) && text.matches(ROLE_REGEXP);
	}

}
