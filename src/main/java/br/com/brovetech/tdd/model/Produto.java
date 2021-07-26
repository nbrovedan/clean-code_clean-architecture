package br.com.brovetech.tdd.model;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class Produto {

    Long id;
    String nome;
    String descricao;
    BigDecimal valor;
}
