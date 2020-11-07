package com.basico.vendas.repositories;

import com.basico.vendas.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<Usuario, Long> {

}
