package br.com.koala.listener.text;

import static com.pengrad.telegrambot.model.request.ParseMode.Markdown;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;

import br.com.koala.configuration.Command;
import br.com.koala.role.Role;
import br.com.koala.role.RoleRepository;

@Component
class ShowRolesListener extends TextListener {
	
	private final RoleRepository repository;

	@Autowired
	ShowRolesListener(TelegramBot bot, RoleRepository repository) {
		super(bot);
		this.repository = repository;
	}

	@Override
	public SendMessage listen(Message message) {
		List<Role> roles = repository.findAll();
			
		if (roles.isEmpty()) {
			InlineKeyboardMarkup newRoleKeyboard = new InlineKeyboardMarkup(new InlineKeyboardButton[]{
	                new InlineKeyboardButton("Marcar role").callbackData("/marcar_role")
	        });

			return new SendMessage(message.chat().id(), "*Nenhum* rolê marcado \uD83D\uDE12")
						.parseMode(Markdown)
						.replyMarkup(newRoleKeyboard);
		}
		
		StringBuilder messageToSend = new StringBuilder("Rolês marcados: \n");
		
		roles.forEach(role -> {
			messageToSend.append(role.getFormattedDate() + " - *" + role.getTitle() + "*" + "\n");
		});
		
		messageToSend.append("\nEae, vamo fecha ?");
		
		return new SendMessage(message.chat().id(), messageToSend.toString())
						.parseMode(ParseMode.Markdown);
	}

	@Override
	public boolean match(Message message) {
		return Command.is(message.text(), Command.ROLES);
	}

}
