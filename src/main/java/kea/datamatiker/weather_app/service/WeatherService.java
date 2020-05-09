package kea.datamatiker.weather_app.service;

import kea.datamatiker.weather_app.model.Weather;
import kea.datamatiker.weather_app.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.TimeZone;
import java.util.*;

@Service
public class WeatherService {

    @Autowired
    WeatherRepository weatherRepository;

    @Autowired
    RestTemplate restTemplate;

    // Methods
    // create and save a weather record
    public void save(Weather weather) {
        weatherRepository.save(weather);

    }

    public Weather update(Weather weather) {
        weatherRepository.save(weather);
        return weather;
    }

    public void delete(int id) {
        weatherRepository.deleteById(id);
    }

    public Weather findById(int id) {
        //findById gives en option
        Optional<Weather> entriesOptional = weatherRepository.findById(id);

        // If there not a country id  exist throw an exception
        if (!entriesOptional.isPresent()) {
            throw new RuntimeException("Weather not found");
        }
        //Returns WeatherInfo such as .get()
        return entriesOptional.get();
    }

    public List<Weather> getAll() {

        // calling repo. get all method
        List<Weather> entries = new ArrayList<>();

        for (Weather weather : weatherRepository.findAll()) {
            weatherRepository.save(weather);
        }
        return entries;

    }

    @GetMapping("/weather")
    public Weather newForecast(String name) {

        Weather newWeatherForecast = new Weather();
        String url = "https://api.openweathermap.org/data/2.5/weather?q="+name+"&appid=5df732fe06e1fe767f1605e2d8cb15c2&units=metric";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println(response.getStatusCode());
        String result = response.getBody();

        String[] list = result.split(",");

        //remove all the un-necessary characters
        for (String s : list) {
            String resultStr = "";
            for (int i=0;i<s.length();i++)
              {
                if (s.charAt(i)>64 && s.charAt(i)<=122)
                {
                  resultStr = resultStr + s.charAt(i);
                }
                else if (s.charAt(i)>=46 && s.charAt(i)<=58){
                    resultStr = resultStr + s.charAt(i);
                }
            }

            String[] parValue = resultStr.split(":");
            if (parValue[0].equals("name")) {
                newWeatherForecast.setName(parValue[1]);
            } else if (parValue[0].equals("main") && (parValue[1].equals("temp"))) {
                newWeatherForecast.setTemperature(Double.valueOf(parValue[2]));
            } else if (parValue[0].equals("feels_like")) {
                newWeatherForecast.setFeels_like(Double.valueOf(parValue[1]));
            } else if (parValue[0].equals("temp_min")) {
                newWeatherForecast.setTemp_min(Double.valueOf(parValue[1]));
            } else if (parValue[0].equals("temp_max")) {
                newWeatherForecast.setTemp_max(Double.valueOf(parValue[1]));
            } else if (parValue[0].equals("pressure")) {
                newWeatherForecast.setPressure(Double.valueOf(parValue[1]));
            } else if (parValue[0].equals("humidity")) {
                newWeatherForecast.setHumidity(Integer.valueOf(parValue[1]));
            } else if (parValue[0].equals("wind") &&(parValue[1].equals("speed"))) {
                newWeatherForecast.setWindspeed(Double.valueOf(parValue[2]));
            }
        }
            newWeatherForecast.setDate(new Date());
            return newWeatherForecast;

    }

    }






