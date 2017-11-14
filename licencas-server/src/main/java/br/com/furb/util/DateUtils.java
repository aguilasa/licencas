package br.com.furb.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

	public static Date getExpiraEm() {
		Date in = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
		ldt = ldt.plusMinutes(1);
		return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
	}
	
	public static Date getLimite() {
		Date in = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
		ldt = ldt.plusMinutes(-2);
		return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
	}
}
