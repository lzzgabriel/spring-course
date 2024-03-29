package dev.lzzgabriel.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.lzzgabriel.course.entities.Order;
import dev.lzzgabriel.course.repositories.OrderRepository;

@Service
public class OrderService {

  @Autowired
  private OrderRepository repository;

  public List<Order> findAll() {
    return repository.findAll();
  }
  
  public Order findById(Long id) {
    var op = repository.findById(id);
    return op.get();
  }

}
