package br.com.koala.configuration;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(SCOPE_SINGLETON)
public class UpdateOffset {

	private int offset = 0;
	
	public void increment(int offset) {
		this.offset = offset + 1;
	}
	
	public int get() {
		return offset;
	}
}
