package br.com.brovetech.tdd.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Cliente {

    Long id;
    String nome;
    String documento;
}
