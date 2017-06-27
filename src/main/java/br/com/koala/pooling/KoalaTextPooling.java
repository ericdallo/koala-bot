package br.com.koala.pooling;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import br.com.koala.configuration.KoalaProperties;

public abstract class KoalaTextPooling extends TelegramLongPollingBot {

	public abstract void listen(Message message);
	
	public abstract boolean match(Message message);
	
	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText() && match(update.getMessage())) {
			listen(update.getMessage());
		}
	}
	

	@Override
	public String getBotUsername() {
		return KoalaProperties.get("telegram.bot.name");
	}

	@Override
	public String getBotToken() {
		return KoalaProperties.get("telegram.bot.token");
	}
	
}
