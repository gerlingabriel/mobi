package com.desafio.mobi.db;

import java.math.BigDecimal;
import java.util.List;

import com.desafio.mobi.model.Pedido;
import com.desafio.mobi.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CriacaoDadosBasico implements CommandLineRunner {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void run(String... args) throws Exception {

        
        if (pedidoRepository.findAll().isEmpty()) {

            Pedido pedido = new Pedido();
            pedido.setNome("DeathStar");
            pedido.setNomePedido("Exaustor");
            pedido.setValorPedido(BigDecimal.valueOf(155.55));

            Pedido pedido2 = new Pedido();
            pedido2.setNome("DeathStar");
            pedido2.setNomePedido("Exaustor Peq");
            pedido2.setValorPedido(BigDecimal.valueOf(58));

            Pedido pedido3 = new Pedido();
            pedido3.setNome("DeathStar");
            pedido3.setNomePedido("Exaustor Médio");
            pedido3.setValorPedido(BigDecimal.valueOf(265.78));

            Pedido pedido4 = new Pedido();
            pedido4.setNome("DeathStar");
            pedido4.setNomePedido("Exaustor Grande");
            pedido4.setValorPedido(BigDecimal.valueOf(1500)); 

            pedidoRepository.saveAll(List.of(pedido, pedido2, pedido3, pedido4));
        }        
    }
    
}
