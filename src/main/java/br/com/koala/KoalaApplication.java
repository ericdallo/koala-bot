package br.com.koala;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories
public class KoalaApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(KoalaApplication.class)
			.web(false)
			.run(args);
	}
}
