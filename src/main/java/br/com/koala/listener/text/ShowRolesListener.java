package br.com.koala.listener.text;

import static com.pengrad.telegrambot.model.request.ParseMode.Markdown;
import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;

import br.com.koala.configuration.Command;
import br.com.koala.role.ListRolesKeyboard;
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
		List<Role> roles = repository.findAll()
							.stream()
							.filter(role -> role.getTitle() != null)
							.collect(toList());
		
		InlineKeyboardMarkup newRoleKeyboard = new InlineKeyboardMarkup(new InlineKeyboardButton[]{
						new InlineKeyboardButton("Marcar novo role").callbackData("/marcar_role")
		});
			
		if (roles.isEmpty()) {
			return new SendMessage(message.chat().id(), "*Nenhum* rolê marcado \uD83D\uDE12")
						.parseMode(Markdown)
						.replyMarkup(newRoleKeyboard);
		}
		
		String messageToSend = "Eae, vamo fecha ?";
		
		return new SendMessage(message.chat().id(), messageToSend)
						.parseMode(Markdown)
						.replyMarkup(new ListRolesKeyboard(roles).buildKeyboard());
	}

	@Override
	public boolean match(Message message) {
		return Command.is(message.text(), Command.ROLES);
	}

}
