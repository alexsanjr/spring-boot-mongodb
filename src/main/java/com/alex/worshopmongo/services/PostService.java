package com.alex.worshopmongo.services;

import com.alex.worshopmongo.domain.Post;
import com.alex.worshopmongo.repository.PostRepository;
import com.alex.worshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate) {
        maxDate = maxDate.plusDays(1L);
        minDate = minDate.minusDays(1L);
        return repository.fullSearch(text, minDate, maxDate);
    }

}
