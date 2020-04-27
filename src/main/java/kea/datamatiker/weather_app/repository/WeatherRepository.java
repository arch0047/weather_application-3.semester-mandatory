package kea.datamatiker.weather_app.repository;

import kea.datamatiker.weather_app.model.WeatherInfo;
import org.springframework.data.repository.CrudRepository;




import org.springframework.stereotype.Repository;
@Repository
public interface WeatherRepository extends CrudRepository <WeatherInfo, Integer>{



}
