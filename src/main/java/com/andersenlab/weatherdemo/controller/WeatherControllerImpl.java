package com.andersenlab.weatherdemo.controller;

import com.andersenlab.weatherdemo.exception.UnauthorizedAccessException;
import com.andersenlab.weatherdemo.model.dto.WeatherDTO;
import com.andersenlab.weatherdemo.service.WeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class WeatherControllerImpl implements WeatherController {

    private final WeatherService weatherService;

    private final String editorPassword;

    public WeatherControllerImpl(WeatherService weatherService,
                                 @Value("${weather-demo.auth.editor_password}") String editorPassword) {
        this.weatherService = weatherService;
        this.editorPassword = editorPassword;
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public WeatherDTO getWeatherById(long id) {
        return weatherService.getWeatherById(id);
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<WeatherDTO> getWeather(Optional<LocalDate> date,
                                       Optional<String> city,
                                       Optional<String> sort) {


        return weatherService.getWeather(date, city, sort);
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public WeatherDTO createWeatherRecord(WeatherDTO weatherDTO, Optional<String> bearerToken) {
        String token = bearerToken.orElseThrow(UnauthorizedAccessException::new);

        if (token.contains("Bearer") && token.substring(7).equals(editorPassword)) {
            return weatherService.createWeatherRecord(weatherDTO);
        } else {
            throw new UnauthorizedAccessException();
        }
    }
}
