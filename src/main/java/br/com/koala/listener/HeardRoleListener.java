package br.com.koala.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.SendMessage;

import br.com.koala.pooling.TextListener;

@Component
class HeardRoleListener extends TextListener {

	@Autowired
	HeardRoleListener(TelegramBot bot) {
		super(bot);
	}

	@Override
	public void listen(Message message) {
		
		bot.execute(new SendMessage(message.chat().id(), "Ouvi rolê?"));
	}

	@Override
	public boolean match(Message message) {
		String text = message.text();
		
		return text.contains(" role") || text.contains(" rolê");
	}

}
