package br.com.koala.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;

@Configuration
class TelegramConfiguration {
	
	@Value("${telegram.bot.token}")
	private String token;

	@Bean
	TelegramBot telegramBot() {
		return TelegramBotAdapter.build(token);
	}
}
