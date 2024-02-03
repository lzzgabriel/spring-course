package dev.lzzgabriel.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import dev.lzzgabriel.course.entities.User;
import dev.lzzgabriel.course.repositories.UserRepository;
import dev.lzzgabriel.course.services.exceptions.DatabaseException;
import dev.lzzgabriel.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public List<User> findAll() {
    return repository.findAll();
  }

  public User findById(Long id) {
    var op = repository.findById(id);
    return op.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public User insert(User obj) {
    return repository.save(obj);
  }

  public void delete(Long id) {
    try {
      if (repository.existsById(id)) {
        repository.deleteById(id);
      } else {
        throw new ResourceNotFoundException(id);
      }
    } catch (DataIntegrityViolationException e) {
      throw new DatabaseException(e.getMessage());
    }
  }

  public User update(Long id, User obj) {
    try {
      var entity = repository.getReferenceById(id);
      updateData(entity, obj);
      return repository.save(entity);
    } catch (EntityNotFoundException e) {
      throw new ResourceNotFoundException(id);
    }
  }

  private void updateData(User entity, User obj) {
    entity.setName(obj.getName());
    entity.setEmail(obj.getEmail());
    entity.setPhone(obj.getPhone());
  }

}
