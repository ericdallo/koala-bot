package br.com.koala.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pengrad.telegrambot.TelegramBot;

@Configuration
class TelegramConfiguration {
	
	@Value("${telegram.bot.token}")
	private String token;

	@Bean
	TelegramBot telegramBot() {
		return new TelegramBot.Builder(token)
				.build();
	}
}
