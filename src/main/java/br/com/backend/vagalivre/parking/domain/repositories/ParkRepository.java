package br.com.backend.vagalivre.parking.domain.repositories;

import br.com.backend.vagalivre.parking.domain.entities.Park;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkRepository extends JpaRepository<Park, Integer> {
}