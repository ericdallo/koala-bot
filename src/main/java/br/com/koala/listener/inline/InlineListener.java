package br.com.koala.listener.inline;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.InlineQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.AnswerInlineQuery;

import br.com.koala.listener.Listener;
import reactor.core.publisher.Mono;

public abstract class InlineListener implements Listener {

	protected final TelegramBot bot;
	
	protected InlineListener(TelegramBot bot) {
		this.bot = bot;
	}

	public abstract AnswerInlineQuery listen(InlineQuery query);
	
	@Override
	public Mono<Void> preListen(Update update) {
		return Mono.defer(() -> {
		
			InlineQuery query = update.inlineQuery();
			
			if (query != null) {
				bot.execute(listen(query));
			}
			
			return Mono.empty();
		});
	}
	
}
