package dev.lzzgabriel.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.lzzgabriel.course.entities.Product;
import dev.lzzgabriel.course.repositories.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;

  public List<Product> findAll() {
    return repository.findAll();
  }
  
  public Product findById(Long id) {
    var op = repository.findById(id);
    return op.get();
  }

}
