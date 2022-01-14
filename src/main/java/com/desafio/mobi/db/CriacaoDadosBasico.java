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
            pedido.setCustomerName("DeathStar");
            pedido.setNomePedido("Exaustor");
            pedido.setTotalPrice(BigDecimal.valueOf(100));

            Pedido pedido2 = new Pedido();
            pedido2.setCustomerName("DeathStar");
            pedido2.setNomePedido("Exaustor Peq");
            pedido2.setTotalPrice(BigDecimal.valueOf(58));

            Pedido pedido3 = new Pedido();
            pedido3.setCustomerName("setCustomerName");
            pedido3.setNomePedido("Exaustor Médio");
            pedido3.setTotalPrice(BigDecimal.valueOf(265.78));

            Pedido pedido4 = new Pedido();
            pedido4.setCustomerName("DeathStar");
            pedido4.setNomePedido("Exaustor Grande");
            pedido4.setTotalPrice(BigDecimal.valueOf(1500)); 

            pedidoRepository.saveAll(List.of(pedido, pedido2, pedido3, pedido4));
        }        
    }
    
}
