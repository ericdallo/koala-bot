package br.com.koala.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import br.com.koala.configuration.Command;
import br.com.koala.nicks.IncestoNicks;
import br.com.koala.pooling.KoalaTextPooling;

public class IncestoNicksListener extends KoalaTextPooling {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(IncestoNicksListener.class);
	
	@Override
	public void listen(Message message) {
		long chatId = message.getChatId();

        SendMessage messageToSend = new SendMessage()
                .setChatId(chatId)
                .setText("Quem é @" + IncestoNicks.random() + " ?");
        try {
            sendMessage(messageToSend);
        } catch (TelegramApiException e) {
            LOGGER.error("Could not send message to chatId: " + chatId, e);
        }
	}

	@Override
	public boolean match(Message message) {
		return Command.is(message.getText(), Command.NICKS);
	}

}
