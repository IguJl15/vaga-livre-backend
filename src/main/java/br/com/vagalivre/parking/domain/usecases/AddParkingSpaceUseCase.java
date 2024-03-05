package br.com.vagalivre.parking.domain.usecases;

import br.com.vagalivre.common.domain.UseCase;
import br.com.vagalivre.parking.domain.entities.Park;
import br.com.vagalivre.parking.domain.entities.ParkSpace;
import br.com.vagalivre.parking.domain.repositories.ParkSpaceRepository;
import br.com.vagalivre.parking.domain.repositories.ParkRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AddParkingSpaceUseCase implements UseCase<ParkSpace,Integer> {
    ParkRepository parkRepository;
    ParkSpaceRepository parkSpaceRepository;

    public AddParkingSpaceUseCase(ParkRepository parkRepository, ParkSpaceRepository parkSpaceRepository){
        this.parkRepository = parkRepository;
        this.parkSpaceRepository = parkSpaceRepository;
    }

    @Override
    public ParkSpace execute(Integer parkId) {
        Park park = parkRepository.getReferenceById(parkId);

        ParkSpace parkSpace = new ParkSpace(null,null, Collections.emptyList(),park);
        return parkSpaceRepository.save(parkSpace);
    }
}
