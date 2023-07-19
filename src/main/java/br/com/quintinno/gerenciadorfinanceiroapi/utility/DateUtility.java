package br.com.quintinno.gerenciadorfinanceiroapi.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtility {
	
	public static final String FORMATO_A = "ddMMyyyy";
	public static final String FORMATO_B = "ddMMyyyyHHmmss";
	
	public static String recuperarDataAtual(String formato) {
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMATO_B);
		return localDateTime.format(dateTimeFormatter);
	}

}
