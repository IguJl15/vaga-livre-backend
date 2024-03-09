package br.com.backend.vagalivre.parking.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ParkDTO {
    String name;
    String description;
    Double hourlyRate;
    String contactInfo;
    LocalDateTime startTime;
    LocalDateTime endDateTime;
}
