package com.ubots.loja.util;

import java.time.LocalDate;

public class Util {

    public static LocalDate toLocalDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return localDate;
    }
}
