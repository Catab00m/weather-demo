package com.andersenlab.weatherdemo.controller;

import com.andersenlab.weatherdemo.model.dto.WeatherDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequestMapping
public interface WeatherController {

    @GetMapping("/weather/{id}")
    WeatherDTO getWeatherById(@PathVariable long id);

    @GetMapping("/weather")
    List<WeatherDTO> getWeather(
            @RequestParam Optional<LocalDate> date,
            @RequestParam Optional<String> city,
            @RequestParam Optional<String> sort);

    @PostMapping("/weather")
    WeatherDTO createWeatherRecord(@RequestBody @Valid WeatherDTO weather,
                                   @RequestHeader(value = "Authorization") Optional<String> bearerToken);
}
