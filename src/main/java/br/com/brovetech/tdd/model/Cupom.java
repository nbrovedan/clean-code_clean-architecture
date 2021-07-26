package br.com.brovetech.tdd.model;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class Cupom {

    Long id;
    String descricao;
    String codigo;
    BigDecimal percentualDesconto;
}
