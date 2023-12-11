package com.andersenlab.weatherdemo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "temperatures")
@NoArgsConstructor
@Getter
@Setter
public class Temperature {

    public Temperature(Weather weather, double temperature) {
        this.weather = weather;
        this.temperature = temperature;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "weather_id")
    Weather weather;

    double temperature;
}
