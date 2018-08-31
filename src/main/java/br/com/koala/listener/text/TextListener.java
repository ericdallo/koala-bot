package br.com.koala.listener.text;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.AbstractSendRequest;
import com.pengrad.telegrambot.request.SendChatAction;

import br.com.koala.listener.Listener;
import reactor.core.publisher.Mono;

public abstract class TextListener implements Listener {
	
	protected final TelegramBot bot;
	
	protected TextListener(TelegramBot bot) {
		this.bot = bot;
	}

	public abstract AbstractSendRequest<?> listen(Message message);
	
	public abstract boolean match(Message message);
	
	@Override
	public Mono<Void> preListen(Update update) {
		return Mono.defer(() -> {
			Message message = update.message();
			
			if (message != null && message.text() != null && match(message)) {
				bot.execute(new SendChatAction(message.chat().id(), ChatAction.typing.name()));
				
				AbstractSendRequest<?> messageToReply = listen(message);
				
				bot.execute(messageToReply);
			}
			return Mono.empty();
		});
	}

}
