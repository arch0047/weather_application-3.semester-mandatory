package kea.datamatiker.weather_app.service;


import kea.datamatiker.weather_app.model.WeatherInfo;
import kea.datamatiker.weather_app.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WeatherService {

    @Autowired
    WeatherRepository weatherRepository;

    // Methods
    public void add(WeatherInfo entries) {
        weatherRepository.save(entries);

    }

    public void update(WeatherInfo entries) {
       weatherRepository.save(entries);
    }


    public void delete(int id) {
        weatherRepository.deleteById(id);
    }



    public WeatherInfo findById(int id) {
        //findById gives en option
        Optional<WeatherInfo> entriesOptional = weatherRepository.findById(id);

        // If there not a country id  exist throw an exception
        if (!entriesOptional.isPresent()) {
            throw new RuntimeException("Weather not found");
        }
        //Returns WeatherInfo such as .get()
        return entriesOptional.get();
    }


    public List< WeatherInfo> getAll() {

        // calling repo. get all method
        List<WeatherInfo> entries = new ArrayList<>();

        for (WeatherInfo weatherInfo:weatherRepository.findAll()) {
            weatherRepository.save(weatherInfo);
        }
        return entries;

    }
}


