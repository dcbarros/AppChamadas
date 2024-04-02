package br.com.professor.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverter {
    public static LocalDate String2LocalDate(String strDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(strDate, formatter);
    }
    public static String LocalDate2String(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }
}
