package br.com.koala.configuration;

public enum Command {

	ROLES,
	NICKS;

	public static boolean is(String text, Command command) {
		return text.startsWith("/" + command.name().toLowerCase());
	}
}
