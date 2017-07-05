package br.com.koala.listener.callback;

import static br.com.koala.role.ListRolesKeyboard.REMOVE_ROLE_PREFIX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.request.SendMessage;

import br.com.koala.role.RoleRepository;

@Component
class RemoveRoleCallbackListener extends CallbackListener {
	
	private final RoleRepository roleRepository;

	@Autowired
	RemoveRoleCallbackListener(TelegramBot bot, RoleRepository roleRepository) {
		super(bot);
		this.roleRepository = roleRepository;
	}

	@Override
	public void listen(CallbackQuery callback) {
		String idToRemove = callback.data().split(REMOVE_ROLE_PREFIX)[1];
		
		roleRepository.findById(Long.parseLong(idToRemove))
					  .ifPresent(role -> {
						  roleRepository.delete(role);
						  
						  bot.execute(new SendMessage(callback.message().chat().id(), "Excluído role: " + role.getTitle()));
					  });
	}

	@Override
	public boolean match(CallbackQuery callback) {
		return callback.data().startsWith(REMOVE_ROLE_PREFIX);
	}

}
