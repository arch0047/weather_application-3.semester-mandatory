package kea.datamatiker.weather_app.repository;

import kea.datamatiker.weather_app.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
@Repository
public interface WeatherRepository extends JpaRepository<Weather,Integer> {



}
