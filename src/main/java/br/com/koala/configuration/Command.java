package br.com.koala.configuration;

public enum Command {

	NICKS("nicks"),
	ROLES("roles"),
	NEW_ROLE("marcar_role"), 
	;
	
	private String name;
	
	private Command(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public static boolean is(String text, Command command) {
		return text.startsWith("/" + command.name);
	}
}
