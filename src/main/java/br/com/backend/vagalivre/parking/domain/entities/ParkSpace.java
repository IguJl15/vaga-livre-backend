package br.com.backend.vagalivre.parking.domain.entities;

import java.util.List;

import br.com.backend.vagalivre.reservation.domain.entities.Reservation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table
public class ParkSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Reservation activeReservation;

    @OneToMany
    private List<Reservation> reservations;

    @ManyToOne
    private Park park;

    public ParkSpace(Reservation activeReservation, List<Reservation> reservations, Park park) {
        this.activeReservation = activeReservation;
        this.reservations = reservations;
        this.park = park;
    }
}
