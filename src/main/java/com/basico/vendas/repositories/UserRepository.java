package com.basico.vendas.repositories;

import com.basico.vendas.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {

}
