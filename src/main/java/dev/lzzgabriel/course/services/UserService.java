package dev.lzzgabriel.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.lzzgabriel.course.entities.User;
import dev.lzzgabriel.course.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public List<User> findAll() {
    return repository.findAll();
  }
  
  public User findById(Long id) {
    var op = repository.findById(id);
    return op.get();
  }
  
  public User insert(User obj) {
    return repository.save(obj);
  }
  
  public void delete(Long id) {
    repository.deleteById(id);
  }
  
  public User update(Long id, User obj) {
    var entity = repository.getReferenceById(id);
    updateData(entity, obj);
    return repository.save(entity);
  }
  
  private void updateData(User entity, User obj) {
    entity.setName(obj.getName());
    entity.setEmail(obj.getEmail());
    entity.setPhone(obj.getPhone());
  }

}
