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
import br.com.koala.pooling.TextListener;

@Component
class KoalaLongPooling {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(KoalaLongPooling.class);
	
	@Autowired
	private TelegramBot bot;
	@Autowired
	private List<TextListener> koalaTextPooling;
	@Autowired
	private UpdateOffset updateOffset;
	
	@Scheduled(fixedDelayString = "${pooling.frequency}")
	void pooling() {
		bot.execute(new GetUpdates().limit(100).offset(updateOffset.get()))
		   .updates()
		   .forEach(update -> {
			   updateOffset.increment(update.updateId());
			   try {
				   koalaTextPooling.forEach(listener -> listener.preListen(update));
			   } catch (Exception e) {
				   LOGGER.error("Error on listening", e);
			   }
		   });
	}

}
