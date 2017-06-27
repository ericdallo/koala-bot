package br.com.koala.nicks;

import java.util.Random;

public enum IncestoNicks {

	CAROLUNAS,
	PUDINZAO,
	DOLLYNETTE,
	GORDOMON,
	DOUBLE,
	BOTIJAO,
	GREGA,
	WESLEY,
	JOAOSEMBRACO,
	MARTAMAE,
	CLOROBOY,
	BLUECODE,
	OO,
	;

	public static String random() {
		Random generator = new Random();
		int randomIndex = generator.nextInt(values().length);
		return values()[randomIndex].name().toLowerCase();
	}
}
