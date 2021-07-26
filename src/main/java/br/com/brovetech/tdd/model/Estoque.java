package br.com.brovetech.tdd.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Estoque {

    Long id;
    Produto produto;
    Long quantidade;
}
