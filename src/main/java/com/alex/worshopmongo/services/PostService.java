package com.alex.worshopmongo.services;

import com.alex.worshopmongo.domain.Post;
import com.alex.worshopmongo.repository.PostRepository;
import com.alex.worshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}