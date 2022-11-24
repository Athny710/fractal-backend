package com.example.fractal.service;

import com.example.fractal.exception.BaseException;
import com.example.fractal.persistence.entity.UserEntity;
import com.example.fractal.persistence.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // Obtener todos los usuarios exitentes
    public List<UserEntity> getAllUsers(){
        return this.userRepository.findAll();
    }

    // Obtener un usuarios por su ID
    public UserEntity getUserById(Long id){
        return this.userRepository.findById(id).orElseThrow( () ->
                new BaseException("No existe el usuario con el ID brindado", HttpStatus.NOT_FOUND)
        );
    }
}
