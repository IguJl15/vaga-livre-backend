package br.com.vagalivre.parking.domain.entities;

import br.com.vagalivre.reservation.domain.entities.Reservation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PARKING_SPACE")
public class ParkSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Reservation activeResevation;
    @OneToMany
    private List<Reservation> resevations;
    @ManyToOne
    private Park park;
}
