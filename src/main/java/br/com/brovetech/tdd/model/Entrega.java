package br.com.brovetech.tdd.model;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class Entrega {

    Long id;
    String cep;
    String logradouro;
    String numero;
    String complemento;
    String transportadora;
    BigDecimal valorFrete;
}
