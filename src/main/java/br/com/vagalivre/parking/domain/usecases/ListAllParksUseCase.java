package br.com.vagalivre.parking.domain.usecases;

import br.com.vagalivre.common.domain.OutPutUseCase;
import br.com.vagalivre.parking.domain.entities.Park;
import br.com.vagalivre.parking.domain.repositories.ParkRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllParksUseCase implements OutPutUseCase<List<Park>> {
    private final ParkRepository parkingRepository;

    @Autowired
    public ListAllParksUseCase(ParkRepository parkingRepository){
        this.parkingRepository = parkingRepository;
    }

    @Override
    public List<Park> call() {
        return parkingRepository.findAll();
    }
}
