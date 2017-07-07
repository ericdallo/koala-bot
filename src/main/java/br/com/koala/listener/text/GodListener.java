package br.com.koala.listener.text;

import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.SendMessage;

@Component
public class GodListener extends TextListener {
	
	private static final String DEUS_REGEXP = "(.*)(d|D)(e|E)(u|U)(s|S)(.*)";
	private static final String GOD_REGEXP = "(.*)(g|G)(o|O)(d|D)(.*)";
	
	GodListener(TelegramBot bot) {
		super(bot);
	}

	@Override
	public SendMessage listen(Message message) {
		return new SendMessage(message.chat().id(), "Hail Satan, He's our god!");
	}

	@Override
	public boolean match(Message message) {
		String text = message.text();
		return text.matches(DEUS_REGEXP) || text.matches(GOD_REGEXP);
	}

}
