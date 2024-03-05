package br.com.vagalivre.parking.domain.repositories;

import br.com.vagalivre.parking.domain.entities.ParkSpace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkSpaceRepository extends JpaRepository<ParkSpace, Integer> {
}
