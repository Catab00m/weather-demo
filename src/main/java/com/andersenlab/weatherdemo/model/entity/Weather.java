package com.andersenlab.weatherdemo.model.entity;


import com.andersenlab.weatherdemo.model.dto.WeatherDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather {

    public Weather(WeatherDTO weatherDTO) {
        this.date = weatherDTO.getDate();
        this.lat = weatherDTO.getLat();
        this.lon = weatherDTO.getLon();
        this.city = weatherDTO.getCity();
        this.state = weatherDTO.getState();

        this.temperatures = Arrays.stream(weatherDTO.getTemperatures())
                .mapToObj((temp) -> new Temperature(this, temp))
                .toList();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate date;

    private double lat;

    private double lon;

    private String city;

    private String state;

    @OneToMany(mappedBy = "weather", cascade = CascadeType.ALL)
    private List<Temperature> temperatures;
}
