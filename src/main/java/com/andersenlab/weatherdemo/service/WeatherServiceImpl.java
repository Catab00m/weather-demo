package com.andersenlab.weatherdemo.service;

import com.andersenlab.weatherdemo.exception.WeatherNotFoundException;
import com.andersenlab.weatherdemo.model.dto.WeatherDTO;
import com.andersenlab.weatherdemo.model.entity.Weather;
import com.andersenlab.weatherdemo.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService{

    private final WeatherRepository weatherRepository;

    @Override
    public WeatherDTO getWeatherById(long id) {
        Weather weather = weatherRepository.findById(id).orElseThrow(WeatherNotFoundException::new);
        return new WeatherDTO(weather);
    }

    @Override
    public WeatherDTO createWeatherRecord(WeatherDTO weatherDTO) {
        Weather weather = new Weather(weatherDTO);

        weatherRepository.save(weather);

        weatherDTO.setId(weather.getId());
        return weatherDTO;
    }

    @Override
    public List<WeatherDTO> getWeather(Optional<LocalDate> date, Optional<String> city, Optional<String> sort) {
        List<Weather> weatherList = getWeatherListByArguments(date, city);

        sort.ifPresent(s -> sortWeatherList(weatherList, s));

        if (weatherList.isEmpty()) {
            throw new WeatherNotFoundException();
        } else {
            return weatherList.stream().map(WeatherDTO::new).toList();
        }
    }

    private List<Weather> getWeatherListByArguments(Optional<LocalDate> date, Optional<String> city) {

        List<String> cities = city.isPresent() ?
                Arrays.stream(city.orElse("").split(",")).toList() : new ArrayList<>();

        if (date.isPresent() && !cities.isEmpty()) {
            return weatherRepository.findAllByDateAndCityIgnoreCaseIn(date.get(), cities);
        }

        if (date.isPresent()) {
            return weatherRepository.findAllByDate(date.get());
        }

        if (!cities.isEmpty()) {
            return weatherRepository.findAllByCityIgnoreCaseIn(cities);
        }

        return weatherRepository.findAll();
    }

    private void sortWeatherList(List<Weather> weatherList, String sort) {
        switch (sort) {
            case "date" -> weatherList.sort((first, second) -> {
                if (first.getDate().isEqual(second.getDate())) {
                    return Long.compare(first.getId(), second.getId());
                } else {
                    return first.getDate().compareTo(second.getDate());
                }
            });
            case "-date" -> weatherList.sort((first, second) -> {
                if (second.getDate().isEqual(first.getDate())) {
                    return Long.compare(first.getId(), second.getId());
                } else {
                    return second.getDate().compareTo(first.getDate());
                }
            });
        }

    }
}
