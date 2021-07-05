package com.example.iagokaic.workshopmongo.services;

import com.example.iagokaic.workshopmongo.domain.Post;
import com.example.iagokaic.workshopmongo.repository.PostRepository;
import com.example.iagokaic.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }

    public  List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);  // adiconando um dia para buscar meia noite do dia posterior informado
        return repository.fullSearch(text, minDate, maxDate);
    }

}
