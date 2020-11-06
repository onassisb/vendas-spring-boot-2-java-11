package com.basico.vendas.services;

import com.basico.vendas.entities.Categoria;
import com.basico.vendas.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){return categoriaRepository.findAll();}
    public Categoria findById(Long id){return categoriaRepository.findById(id).get();}
}
