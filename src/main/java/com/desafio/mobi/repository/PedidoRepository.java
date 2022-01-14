package com.desafio.mobi.repository;

import java.util.List;
import java.util.Optional;

import com.desafio.mobi.model.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    Optional<List<Pedido>> findByCustomerName(String string);

    @Query(nativeQuery = true, value = "SELECT * FROM PEDIDO WHERE CustomerName = :string")
    List<Pedido> buscarListaPedidoPorNome(String string);
    
}
