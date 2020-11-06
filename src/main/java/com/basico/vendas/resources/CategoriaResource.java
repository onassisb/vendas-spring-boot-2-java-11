package com.basico.vendas.resources;

import com.basico.vendas.entities.Categoria;
import com.basico.vendas.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @RequestMapping
    public ResponseEntity<List<Categoria>> findAll(){
        return ResponseEntity.ok().body(categoriaService.findAll());
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(categoriaService.findById(id));
    }
    
}
