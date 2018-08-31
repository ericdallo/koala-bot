package br.com.koala;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetUpdates;

import br.com.koala.configuration.UpdateOffset;
import br.com.koala.listener.Listener;
import br.com.koala.listener.callback.CallbackListener;
import br.com.koala.listener.inline.InlineListener;
import br.com.koala.listener.text.TextListener;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
class KoalaLongPooling {

	private final static Logger LOGGER = LoggerFactory.getLogger(KoalaLongPooling.class);

	@Autowired
	private TelegramBot bot;
	@Autowired
	private List<TextListener> textPooling;
	@Autowired
	private UpdateOffset updateOffset;
	@Autowired
	private List<InlineListener> inlinePooling;
	@Autowired
	private List<CallbackListener> callbackPooling;

	@Scheduled(fixedDelayString = "${pooling.frequency}")
	void pooling() {
		
		Mono.defer(() -> Mono.justOrEmpty(readMessages()))
			.flatMapMany(Flux::fromIterable)
			.doOnNext(update -> updateOffset.increment(update.updateId()))
			.flatMap(update ->
			   
				Flux.concat(
						Flux.fromIterable(textPooling), 
						Flux.fromIterable(inlinePooling), 
						Flux.fromIterable(callbackPooling))
				.cast(Listener.class)
				.flatMap(listener -> listener.preListen(update))
				.doOnError(e -> LOGGER.error("Error on listening update + " + update, e))
				.subscribeOn(Schedulers.elastic())
		   )
			.subscribe();
	}

	private List<Update> readMessages() {
		return bot.execute(new GetUpdates().limit(100).offset(updateOffset.get())).updates();
	}

}
