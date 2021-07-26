package br.com.brovetech.tdd.model;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
@Builder
public class Pedido {

    Long id;
    Cliente cliente;
    List<PedidoItem> itens;
    BigDecimal valorTotal;
    Cupom cupomDesconto;
    Entrega entrega;
}
