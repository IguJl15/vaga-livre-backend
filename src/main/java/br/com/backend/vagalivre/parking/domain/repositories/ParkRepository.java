package br.com.backend.vagalivre.parking.domain.repositories;

import br.com.backend.vagalivre.parking.domain.entities.Park;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkRepository extends JpaRepository<Park, Integer> {
    List<Park> findByNameContainingIgnoreCaseAndDescriptionIgnoreCase(
            String name,
            String description
    );
}