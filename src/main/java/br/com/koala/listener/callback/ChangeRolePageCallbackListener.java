package br.com.koala.listener.callback;

import static br.com.koala.role.ListRolesKeyboard.LIST_ROLE_PREFIX;
import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.request.EditMessageReplyMarkup;

import br.com.koala.role.ListRolesKeyboard;
import br.com.koala.role.Role;
import br.com.koala.role.RoleRepository;

@Component
class ChangeRolePageCallbackListener extends CallbackListener {
	
	private final RoleRepository roleRepository;

	@Autowired
	ChangeRolePageCallbackListener(TelegramBot bot, RoleRepository roleRepository) {
		super(bot);
		this.roleRepository = roleRepository;
	}

	@Override
	public void listen(CallbackQuery callback) {
		int page = Integer.parseInt(callback.data().split(LIST_ROLE_PREFIX)[1]);
		
		List<Role> roles = roleRepository.findAll()
						.stream()
						.filter(role -> role.getTitle() != null)
						.collect(toList());
		
		bot.execute(new EditMessageReplyMarkup(callback.message().chat().id(), callback.message().messageId())
						.replyMarkup(new ListRolesKeyboard(roles, page).buildKeyboard()));
	}

	@Override
	public boolean match(CallbackQuery callback) {
		return callback.data().startsWith(LIST_ROLE_PREFIX);
	}

}
