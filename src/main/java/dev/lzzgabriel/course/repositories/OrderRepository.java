package dev.lzzgabriel.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.lzzgabriel.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
