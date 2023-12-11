package com.andersenlab.weatherdemo.model.dto;


import com.andersenlab.weatherdemo.model.entity.Temperature;
import com.andersenlab.weatherdemo.model.entity.Weather;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class WeatherDTO {

    public WeatherDTO(Weather weather) {
        this.id = weather.getId();
        this.date = weather.getDate();
        this.lat = weather.getLat();
        this.lon = weather.getLon();
        this.city = weather.getCity();
        this.state = weather.getState();

        this.temperatures = weather.getTemperatures().stream()
                .mapToDouble(Temperature::getTemperature)
                .toArray();

    }

    long id;

    @NotNull
    private LocalDate date;

    @Min(value = -90, message = "Latitude must be in range from -90 to 90")
    @Max(value = 90, message = "Latitude must be in range from -90 to 90")
    private double lat;

    @Min(value = -180, message = "Longitude must be in range from -180 to 180")
    @Max(value = 180, message = "Longitude must be in range from -180 to 180")
    private double lon;

    @NotNull(message = "City must not be null")
    @NotBlank
    private String city;

    @NotNull(message = "State must not be null")
    @NotBlank
    private String state;

    @NotNull(message = "Temperatures must not be null")
    @NotEmpty
    private double[] temperatures;
}
