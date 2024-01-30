package dev.lzzgabriel.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.lzzgabriel.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
