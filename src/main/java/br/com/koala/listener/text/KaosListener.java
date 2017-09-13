package br.com.koala.listener.text;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.SendDocument;

import br.com.koala.kaos.KaosGif;
import br.com.koala.kaos.KaosGifRepository;

@Component
class KaosListener extends TextListener {

	private static final String KAOS_REGEXP = "(.*)(c|C|k|K)(a|A)(o|O)(s|S)(.*)";
	private final KaosGifRepository repository;

	@Autowired
	KaosListener(TelegramBot bot, KaosGifRepository repository) {
		super(bot);
		this.repository = repository;
	}

	@Override
	public SendDocument listen(Message message) {
		Random random = new Random();
		
		List<KaosGif> gifs = repository.findAll();
		
		KaosGif randomKaosGif = gifs.get(random.nextInt(gifs.size()));
		
		return new SendDocument(message.chat().id(), randomKaosGif.getUrl());
	}

	@Override
	public boolean match(Message message) {
		return message.text().matches(KAOS_REGEXP);
	}

}
