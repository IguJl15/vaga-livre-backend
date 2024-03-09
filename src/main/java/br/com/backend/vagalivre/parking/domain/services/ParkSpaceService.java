package br.com.backend.vagalivre.parking.domain.services;

import br.com.backend.vagalivre.parking.domain.entities.Park;
import br.com.backend.vagalivre.parking.domain.entities.ParkSpace;
import br.com.backend.vagalivre.parking.domain.repositories.ParkRepository;
import br.com.backend.vagalivre.parking.domain.repositories.ParkSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ParkSpaceService {

    private final ParkSpaceRepository parkSpaceRepository;
    private final ParkRepository parkRepository;

    @Autowired
    public ParkSpaceService(
            ParkSpaceRepository parkSpaceRepository,
            ParkRepository parkRepository
    ){
        this.parkSpaceRepository = parkSpaceRepository;
        this.parkRepository = parkRepository;
    }

    public List<ParkSpace> getAllParkSpacesInPark(Park park) {
        return parkSpaceRepository.findParkSpaceByPark(park);
    }

    public ParkSpace createNewParkSpace(Integer parkId) {
        Park park = parkRepository.getReferenceById(parkId);

        ParkSpace parkSpace = new ParkSpace(null, null, Collections.emptyList(), park);

        try {
            return parkSpaceRepository.save(parkSpace);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to add a parking space", e);
        }
    }

    public void removeParkSpace(Integer parkId){
        ParkSpace parkSpace =  parkSpaceRepository.getReferenceById(parkId);
        parkSpaceRepository.delete(parkSpace);
    }
}
