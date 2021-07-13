package util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class UTIL {
	
public static String gerarCodigo() {
		
		return UUID.randomUUID().toString().substring(0, 8).toUpperCase(); 
		
	}

		public static String converterData(LocalDate data) {
			String dataFormatada = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			return dataFormatada;
		}
		
		public static String converterHora(LocalTime hora) {
			String horaFormatada = hora.format(DateTimeFormatter.ofPattern("HH:mm"));
			return horaFormatada;
}

} 

