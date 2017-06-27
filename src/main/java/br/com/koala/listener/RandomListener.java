package br.com.koala.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import br.com.koala.configuration.KoalaProperties;

public class RandomListener extends TelegramLongPollingBot {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(RandomListener.class);
	
	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			
	        long chatId = update.getMessage().getChatId();

	        SendMessage message = new SendMessage()
	                .setChatId(chatId)
	                .setText("Koala rules");
	        try {
	            sendMessage(message);
	        } catch (TelegramApiException e) {
	            LOGGER.error("Could not send message to chatId: " + chatId, e);
	        }
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
