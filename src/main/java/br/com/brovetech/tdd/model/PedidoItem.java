package br.com.brovetech.tdd.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PedidoItem {

    Long id;
    Produto produto;
    Long quantidade;
}
