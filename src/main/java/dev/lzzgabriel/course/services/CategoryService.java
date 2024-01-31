package dev.lzzgabriel.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.lzzgabriel.course.entities.Category;
import dev.lzzgabriel.course.repositories.CategoryRepository;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository repository;

  public List<Category> findAll() {
    return repository.findAll();
  }
  
  public Category findById(Long id) {
    var op = repository.findById(id);
    return op.get();
  }

}