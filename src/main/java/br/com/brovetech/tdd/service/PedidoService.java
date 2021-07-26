package br.com.brovetech.tdd.service;

import br.com.brovetech.tdd.exception.PedidoException;
import br.com.brovetech.tdd.model.*;
import br.com.brovetech.tdd.validador.DocumentoValidador;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    public Pedido criarPedido(Cliente cliente, List<PedidoItem> itens, Entrega entrega, Cupom cupom){
        if(!DocumentoValidador.validarCPF(cliente.getDocumento())) throw new PedidoException("CPF inválido");

        return null;
    }
}
