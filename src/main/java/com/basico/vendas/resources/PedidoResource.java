package com.basico.vendas.resources;

import com.basico.vendas.entities.Pedido;
import com.basico.vendas.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @RequestMapping
    public ResponseEntity<List<Pedido>> findAll(){

        return ResponseEntity.ok().body(pedidoService.findAll());
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(pedidoService.findById(id));
    }
}
