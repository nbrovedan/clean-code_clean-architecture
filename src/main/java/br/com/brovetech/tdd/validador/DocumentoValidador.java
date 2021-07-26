package br.com.brovetech.tdd.validador;

import br.com.brovetech.tdd.utils.StringUtils;
import lombok.experimental.UtilityClass;

import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Boolean.FALSE;
import static java.util.Arrays.stream;
import static org.apache.logging.log4j.util.Strings.EMPTY;

@UtilityClass
public class DocumentoValidador {

    private static final int TAMANHO_CPF_SEM_MASCARA = 11;
    public static final int MODULO_CALCULO_DIGITO = 11;

    public Boolean validarCPF(String cpf){
        cpf = StringUtils.somenteDigitos(cpf);
        if(cpf.isEmpty()){
            return FALSE;
        }
        if(cpf.length() != TAMANHO_CPF_SEM_MASCARA){
            return FALSE;
        }
        if(mesmosNumeros(cpf)){
            return FALSE;
        }
        var primeiroDigito = calculaDigitoCPF(cpf, 9);
        var segundoDigito = calculaDigitoCPF(cpf, 10);
        var digitosCPF = cpf.substring(cpf.length() - 2);
        var digitosCalculados = String.format("%d%d", primeiroDigito, segundoDigito);

        return digitosCPF.equals(digitosCalculados);
    }

    private Integer calculaDigitoCPF(String cpf, Integer tamanho){
        var peso = new AtomicReference<>(tamanho + 1);
        var parteDoCPF = cpf.substring(0, tamanho);
        var acumulador = stream(parteDoCPF.split(EMPTY))
                .mapToInt(d -> Integer.parseInt(d) * peso.getAndSet(peso.get() - 1)).sum();
        var digito = MODULO_CALCULO_DIGITO - (acumulador % MODULO_CALCULO_DIGITO);
        return digito >= 10 ? 0 : digito;
    }

    private Boolean mesmosNumeros(String documento){
        return stream(documento.split(EMPTY)).parallel().allMatch(d -> d.equals(documento.substring(0,1)));
    }
}
