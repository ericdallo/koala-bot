package br.com.koala.listener.inline;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.InlineQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.AnswerInlineQuery;

public abstract class InlineListener {

	protected final TelegramBot bot;
	
	protected InlineListener(TelegramBot bot) {
		this.bot = bot;
	}

	public abstract AnswerInlineQuery listen(InlineQuery query);
	
	public void preListen(Update update) {
		InlineQuery query = update.inlineQuery();
		
		if (query != null) {
			bot.execute(listen(query));
		}
	}
	
}
