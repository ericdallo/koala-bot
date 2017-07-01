package br.com.koala;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.GetUpdates;

import br.com.koala.configuration.UpdateOffset;
import br.com.koala.listener.callback.CallbackListener;
import br.com.koala.listener.inline.InlineListener;
import br.com.koala.listener.text.TextListener;

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
		bot.execute(new GetUpdates().limit(100).offset(updateOffset.get()))
		   .updates()
		   .forEach(update -> {
			   
			   //TODO open a thread for each listener for best performance
			   try {
				   textPooling.forEach(listener -> listener.preListen(update));
				   inlinePooling.forEach(listener -> listener.preListen(update));
				   callbackPooling.forEach(listener -> listener.preListen(update));
			   } catch (Exception e) {
				   LOGGER.error("Error on listening", e);
			   }
			   
			   updateOffset.increment(update.updateId());
		   });
	}

}
