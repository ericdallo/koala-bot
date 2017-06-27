package br.com.koala;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import br.com.koala.listener.RandomListener;

public class KoalaApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		
		TelegramBotsApi botsApi = new TelegramBotsApi();

		try {
            botsApi.registerBot(new RandomListener());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
	}
}
