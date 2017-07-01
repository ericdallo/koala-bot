package br.com.koala.listener.callback;

import static br.com.koala.configuration.Command.NEW_ROLE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.request.SendMessage;

import br.com.koala.configuration.Command;
import br.com.koala.listener.text.NewRoleListener;

@Component
class NewRoleCallbackListener extends CallbackListener {

	private NewRoleListener newRoleListener;

	@Autowired
	NewRoleCallbackListener(TelegramBot bot, NewRoleListener newRoleListener) {
		super(bot);
		this.newRoleListener = newRoleListener;
	}

	@Override
	public SendMessage listen(CallbackQuery callback) {
		return newRoleListener.listen(callback.message());
	}

	@Override
	public boolean match(CallbackQuery callback) {
		return Command.is(callback.data(), NEW_ROLE);
	}

}
