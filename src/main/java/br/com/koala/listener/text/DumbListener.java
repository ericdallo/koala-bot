package br.com.koala.listener.text;

import static java.lang.String.format;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.SendMessage;

@Component
class DumbListener extends TextListener {

	private static final String DUMB_REGEXP = "(.*)(B|b)(u|U)(r|R)(r|R)(a|A|o|O)(.*)";
	private static final Pattern pattern = Pattern.compile(DUMB_REGEXP);

	@Autowired
	DumbListener(TelegramBot bot) {
		super(bot);
	}

	@Override
	public SendMessage listen(Message message) {
		Matcher matcher = pattern.matcher(message.text());
		matcher.find();
		String anwser = matcher.group().contains("a") ? "a" : "o";	
		
		return new SendMessage(message.chat().id(), format("Burr%s, burr%s!", anwser, anwser));
	}

	@Override
	public boolean match(Message message) {
		String text = message.text();
		
		return text.matches(DUMB_REGEXP);
	}

}
