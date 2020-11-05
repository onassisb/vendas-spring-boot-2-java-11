package com.basico.vendas.resources;

import com.basico.vendas.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    @RequestMapping
    public ResponseEntity<User> findAll(){
        var u = new User(1L, "Jonh Smith","jonhs@gmail.com","350065553","123456" );
        return ResponseEntity.ok().body(u);
    }
}
