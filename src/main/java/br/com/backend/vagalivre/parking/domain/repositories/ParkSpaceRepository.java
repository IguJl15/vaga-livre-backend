package br.com.backend.vagalivre.parking.domain.repositories;

import br.com.backend.vagalivre.parking.domain.entities.Park;
import br.com.backend.vagalivre.parking.domain.entities.ParkSpace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkSpaceRepository extends JpaRepository<ParkSpace, Integer> {
    List<ParkSpace> findParkSpaceByPark(Park park);
}