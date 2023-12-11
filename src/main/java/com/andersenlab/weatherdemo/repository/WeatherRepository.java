package com.andersenlab.weatherdemo.repository;

import com.andersenlab.weatherdemo.model.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

    List<Weather> findAllByCityIgnoreCaseIn(List<String> cities);

    List<Weather> findAllByDate(LocalDate date);

    List<Weather> findAllByDateAndCityIgnoreCaseIn(LocalDate date, List<String> cities);
}
