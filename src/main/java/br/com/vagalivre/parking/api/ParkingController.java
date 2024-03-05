package br.com.vagalivre.parking.api;

import br.com.vagalivre.parking.domain.entities.Park;
import br.com.vagalivre.parking.domain.entities.ParkSpace;
import br.com.vagalivre.parking.domain.usecases.AddParkingSpaceUseCase;
import br.com.vagalivre.parking.domain.usecases.ListAllParksUseCase;
import br.com.vagalivre.parking.domain.usecases.RemoveParkSpaceUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/parking")
@RestController
public class ParkingController {
    private final ListAllParksUseCase listAllParksUseCase;
    private final RemoveParkSpaceUseCase removeParkSpaceUseCase;
    private final AddParkingSpaceUseCase addParkingSpaceUseCase;

    public ParkingController(ListAllParksUseCase listAllParksUseCase, RemoveParkSpaceUseCase removeParkSpaceUseCase, AddParkingSpaceUseCase addParkingSpaceUseCase) {
        this.listAllParksUseCase = listAllParksUseCase;
        this.removeParkSpaceUseCase = removeParkSpaceUseCase;
        this.addParkingSpaceUseCase = addParkingSpaceUseCase;
    }

    @GetMapping("/")
    public List<Park> listAllParks(){
       return listAllParksUseCase.call();
    }

    @PostMapping("/{parkId}/create")
    public ParkSpace createNewParkSpace(@PathVariable Integer parkId){
        return addParkingSpaceUseCase.execute(parkId);
    }

    @DeleteMapping("/{parkId}/{parkSpaceId}/delete")
    public void deleteParkSpaceById(@PathVariable Integer parkId, @PathVariable Integer parkSpaceId){
        removeParkSpaceUseCase.call(parkSpaceId);
    }
}
