package com.example.iagokaic.workshopmongo.services;

import com.example.iagokaic.workshopmongo.domain.User;
import com.example.iagokaic.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
}
