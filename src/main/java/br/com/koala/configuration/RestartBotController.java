package br.com.koala.configuration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestartBotController {

	@GetMapping("/restart")
	public String restart() {
		return "OK";
	}
}
