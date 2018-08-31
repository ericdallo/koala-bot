package br.com.koala.listener;

import com.pengrad.telegrambot.model.Update;

import reactor.core.publisher.Mono;

public interface Listener {

	Mono<Void> preListen(Update update);

}
