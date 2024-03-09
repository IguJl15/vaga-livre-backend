package br.com.backend.vagalivre.reservation.domain.entities;


import br.com.backend.vagalivre.parking.domain.entities.Park;
import br.com.backend.vagalivre.user.domain.entities.Person;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Park park;

    private LocalTime startTime;

    @OneToOne
    private Person author;

    private Double hourlyRate;
}