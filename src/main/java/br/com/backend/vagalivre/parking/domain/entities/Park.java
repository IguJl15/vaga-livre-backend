package br.com.backend.vagalivre.parking.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Park {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private Double hourlyRate;
    private String contactInfo;
    private LocalDateTime startTime;
    private LocalDateTime endDateTime;

    public Park(String name, String description, Double hourlyRate, String contactInfo, LocalDateTime startTime, LocalDateTime endDateTime){
        this.name = name;
        this.description = description;
        this.hourlyRate = hourlyRate;
        this.contactInfo = contactInfo;
        this.startTime = startTime;
        this.endDateTime = endDateTime;
    }

}