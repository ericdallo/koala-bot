package br.com.koala.listener.callback;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.SendChatAction;

public abstract class CallbackListener {
	
	protected final TelegramBot bot;
	
	protected CallbackListener(TelegramBot bot) {
		this.bot = bot;
	}

	public abstract void listen(CallbackQuery callback);
	
	public abstract boolean match(CallbackQuery callback);
	
	public void preListen(Update update) {
		CallbackQuery callback = update.callbackQuery();
		
		if (callback != null && match(callback)) {
			bot.execute(new SendChatAction(callback.inlineMessageId(), ChatAction.typing.name()));
			
			listen(callback);
		}
	}
}