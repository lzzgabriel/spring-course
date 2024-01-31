package dev.lzzgabriel.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.lzzgabriel.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
