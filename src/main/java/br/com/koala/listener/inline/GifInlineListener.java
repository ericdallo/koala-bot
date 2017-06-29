package br.com.koala.listener.inline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.InlineQuery;
import com.pengrad.telegrambot.model.request.InlineQueryResultGif;
import com.pengrad.telegrambot.request.AnswerInlineQuery;

import br.com.koala.gif.GifRepository;

@Component
class GifInlineListener extends InlineListener {
	
	@Autowired
	private GifRepository gifsRepository;

	@Autowired
	GifInlineListener(TelegramBot bot) {
		super(bot);
	}

	@Override
	public AnswerInlineQuery listen(InlineQuery query) {
		InlineQueryResultGif[] gifs = new InlineQueryResultGif[]{};
		
		gifs = gifsRepository.findAll()
			 .stream()
			 .map(gif -> new InlineQueryResultGif(query.id(), gif.getUrl(), gif.getUrl()))
			 .toArray(InlineQueryResultGif[]::new);
			
		return new AnswerInlineQuery(query.id(), gifs)
				                .cacheTime(7200)
				                .isPersonal(false);
	}

}
