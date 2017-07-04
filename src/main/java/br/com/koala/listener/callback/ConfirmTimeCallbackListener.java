package br.com.koala.listener.callback;

import static br.com.koala.keyboard.CalendarKeyboard.CHOOSE_DATE_PREFIX;
import static com.pengrad.telegrambot.model.request.ParseMode.Markdown;
import static java.lang.String.format;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.EditMessageText;

import br.com.koala.role.Role;
import br.com.koala.role.RoleRepository;
import br.com.koala.utils.SimpleTimeKeyboard;

@Component
class ConfirmTimeCallbackListener extends TimeCallbackListener {
	
	private final RoleRepository roleRepository;
	
	@Autowired
	ConfirmTimeCallbackListener(TelegramBot bot, RoleRepository roleRepository) {
		super(bot);
		this.roleRepository = roleRepository;
	}

	@Override
	public void listen(CallbackQuery callback) { 	
		Long milis = Long.parseLong(callback.data().split("_")[1]);
		
		LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(milis.longValue()), ZoneId.systemDefault());
											 
		String chosenRoleDate = dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		Message message = callback.message();
		
		roleRepository.save(Role.preRole(callback.from().id().longValue(), dateTime));
		
		InlineKeyboardButton[] backToTime = new InlineKeyboardButton[] { new InlineKeyboardButton("⇠ Escolher outra hora").callbackData(CHOOSE_DATE_PREFIX + milis) };
		bot.execute(new EditMessageText(message.chat().id(), message.messageId(), format("(%s)\n\nBeleza, qual o **nome** do role?", chosenRoleDate))
						.parseMode(Markdown)
						.replyMarkup(new InlineKeyboardMarkup(backToTime)));
	}

	@Override
	boolean timeMatch(String action) {
		return action.startsWith(SimpleTimeKeyboard.CONFIRM);
	}

}
