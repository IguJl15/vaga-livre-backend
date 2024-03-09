package br.com.backend.vagalivre.parking.domain.services;

import br.com.backend.vagalivre.parking.domain.dtos.ParkDTO;
import br.com.backend.vagalivre.parking.domain.entities.Park;
import br.com.backend.vagalivre.parking.domain.repositories.ParkRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkService {
    private final ParkRepository parkRepository;

    public ParkService(ParkRepository parkRepository) {
        this.parkRepository = parkRepository;
    }

    public List<Park> findAllParks() {
        return parkRepository.findAll();
    }

    public Park createPark(ParkDTO data) {
        final var park = new Park();
        BeanUtils.copyProperties(data, park);
        return parkRepository.save(park);
    }

    public Park updatePark(Integer parkId, ParkDTO data) {
        Park park = getParkById(parkId);
        BeanUtils.copyProperties(data, park);
        return parkRepository.save(park);
    }

    public void deletePark(Integer parkId){
        Park parkDelete = getParkById(parkId);
        parkRepository.delete(parkDelete);
    }

    public Park getParkById(Integer parkId) {
        return parkRepository.getReferenceById(parkId);
    }
}
