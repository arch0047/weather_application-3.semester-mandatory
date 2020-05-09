package kea.datamatiker.weather_app.controller;
import kea.datamatiker.weather_app.model.Weather;
import kea.datamatiker.weather_app.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    WeatherService weatherService;

    @GetMapping(value= "/welcome")
    public String welcome(Model model) {

       model.addAttribute("weatherForecast", new Weather());
       return "welcome";
    }

    @PostMapping("/welcome")
     public String showWeather(@ModelAttribute Weather weatherForecast, Model model)
    {
       weatherForecast = weatherService.newForecast(weatherForecast.getName());

        weatherService.save(weatherForecast);

       //Mapped values to HTML View
        model.addAttribute("name",       weatherForecast.getName());
        model.addAttribute("id",         weatherForecast.getId());
        model.addAttribute("feels_like", weatherForecast.getFeels_like());
        model.addAttribute("temp_min",   weatherForecast.getTemp_min());
        model.addAttribute("temp_max",   weatherForecast.getTemp_max());
        model.addAttribute("pressure",   weatherForecast.getPressure());
        model.addAttribute("humidity",   weatherForecast.getHumidity());
        model.addAttribute("speed",      weatherForecast.getWindspeed());
        model.addAttribute("date",       weatherForecast.getDate());
        model.addAttribute("temp",       weatherForecast.getTemperature());

        return "/forecast";


    }

}