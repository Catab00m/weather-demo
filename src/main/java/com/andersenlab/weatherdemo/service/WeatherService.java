package com.andersenlab.weatherdemo.service;

import com.andersenlab.weatherdemo.model.dto.WeatherDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WeatherService {

    WeatherDTO createWeatherRecord(WeatherDTO weatherDTO);

    WeatherDTO getWeatherById(long id);

    List<WeatherDTO> getWeather(Optional<LocalDate> date, Optional<String> city, Optional<String> sort);
}
