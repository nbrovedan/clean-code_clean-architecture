package br.com.brovetech.tdd.service;


import br.com.brovetech.tdd.exception.PedidoException;
import br.com.brovetech.tdd.model.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Collections;

@RunWith(MockitoJUnitRunner.class)
public class PedidoServiceTest {

    @InjectMocks
    PedidoService pedidoService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void deveDarErroCPFInvalido(){

        expectedException.expect(PedidoException.class);
        expectedException.expectMessage("CPF inválido");

        var cliente = Cliente.builder()
                .id(1L)
                .documento("05335684999")
                .nome("Ronaldo Nazário")
                .build();

        var produto = Produto.builder()
                .id(1L)
                .nome("Notebook")
                .descricao("Notebook 14")
                .build();

        var pedidoItem = PedidoItem.builder()
                .id(1L)
                .produto(produto)
                .quantidade(1L)
                .build();

        var itens = Collections.singletonList(pedidoItem);

        var entrega = Entrega.builder()
                .id(1L)
                .cep("88132229")
                .logradouro("Rua Capri")
                .complemento("AP103")
                .numero("480")
                .transportadora("Correios")
                .valorFrete(BigDecimal.valueOf(49.51))
                .build();

        var cupom = Cupom.builder()
                .id(1L)
                .descricao("Desconto aniversário")
                .codigo("ANIVER20")
                .percentualDesconto(BigDecimal.valueOf(20))
                .build();

        pedidoService.criarPedido(cliente, itens, entrega, cupom);
    }
}
