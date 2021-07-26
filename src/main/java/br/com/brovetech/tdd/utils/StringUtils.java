package br.com.brovetech.tdd.utils;

import lombok.experimental.UtilityClass;

import java.util.Optional;

import static org.apache.logging.log4j.util.Strings.EMPTY;

@UtilityClass
public class StringUtils {

    private static final String SOMENTE_DIGITOS_REGEX = "\\D";

    public static String somenteDigitos(String str){
        return Optional.ofNullable(str).orElse(EMPTY).replaceAll(SOMENTE_DIGITOS_REGEX, EMPTY);
    }
}
