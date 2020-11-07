package com.basico.vendas.services;

import com.basico.vendas.entities.Usuario;
import com.basico.vendas.repositories.UserRepository;
import com.basico.vendas.services.exceptions.DataBaseException;
import com.basico.vendas.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Usuario> findAll() {
        return userRepository.findAll();
    }

    public Usuario findById(Long id) {

        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Usuario insert(Usuario user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    public Usuario update(Long id, Usuario user) {
        try {
            var entity = userRepository.getOne(id);
            updateData(entity, user);
            return userRepository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Usuario entity, Usuario user) {
        entity.setNome(user.getNome());
        entity.setEmail(user.getEmail());
        entity.setTel(user.getTel());
    }

}
