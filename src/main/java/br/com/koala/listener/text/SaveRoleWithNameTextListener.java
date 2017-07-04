package br.com.koala.listener.text;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.SendMessage;

import br.com.koala.role.Role;
import br.com.koala.role.RoleRepository;

@Component
class SaveRoleWithNameTextListener extends TextListener {
	
	private final RoleRepository roleRepository;
	private Role roleToEdit;

	@Autowired
	SaveRoleWithNameTextListener(TelegramBot bot, RoleRepository roleRepository) {
		super(bot);
		this.roleRepository = roleRepository;
	}

	@Override
	public SendMessage listen(Message message) {
		roleToEdit.changeTitle(message.text());
		
		roleRepository.save(roleToEdit);
		
		return new SendMessage(message.chat().id(), "Rolê marcado \ud83d\ude04");
	}

	@Override
	public boolean match(Message message) {
		Optional<Role> roleToEdit = roleRepository.findByOrganizerIdAndTitleIsNull(message.from().id().longValue());
		
		if (roleToEdit.isPresent()) {
			this.roleToEdit = roleToEdit.get();
			return true;
		}
		
		return false;
	}

}
