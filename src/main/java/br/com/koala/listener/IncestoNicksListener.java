package br.com.koala.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.SendMessage;

import br.com.koala.configuration.Command;
import br.com.koala.nicks.IncestoNicks;

@Component
class IncestoNicksListener extends TextListener {
	
	@Autowired
	IncestoNicksListener(TelegramBot bot) {
		super(bot);
	}
	
	@Override
	public SendMessage listen(Message message) {
		Long chatId = message.chat().id();
		
		return new SendMessage(chatId, "Quem é @" + IncestoNicks.random() + " ?");
	}

	@Override
	public boolean match(Message message) {
		return Command.is(message.text(), Command.NICKS);
	}

}
