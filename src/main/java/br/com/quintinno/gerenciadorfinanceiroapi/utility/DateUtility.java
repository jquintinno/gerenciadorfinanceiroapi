package br.com.quintinno.gerenciadorfinanceiroapi.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtility {
	
	public static final String FORMATO_A = "ddMMyyyy";
	public static final String FORMATO_B = "ddMMyyyy HH:mm:ss";
	
	public static String recuperarDataAtual(String formato) {
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMATO_A);
		return localDate.format(dateTimeFormatter);
	}

}
