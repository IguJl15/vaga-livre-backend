package br.com.vagalivre.parking.domain.usecases;

import br.com.vagalivre.common.domain.InputUseCase;
import br.com.vagalivre.parking.domain.repositories.ParkRepository;
import br.com.vagalivre.parking.domain.repositories.ParkSpaceRepository;
import org.springframework.stereotype.Service;

@Service
public class RemoveParkSpaceUseCase implements InputUseCase<Integer> {
    ParkSpaceRepository parkSpaceRepository;

    public RemoveParkSpaceUseCase(ParkSpaceRepository parkingRepository){
        this.parkSpaceRepository = parkingRepository;
    }


    @Override
    public void call(Integer id) {
        parkSpaceRepository.deleteById(id);
    }
}
