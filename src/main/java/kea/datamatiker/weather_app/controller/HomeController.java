package kea.datamatiker.weather_app.controller;

import kea.datamatiker.weather_app.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    WeatherService weatherService;

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
    @GetMapping("/")
    public String showWeather()
    {
       return ("home");
    }






  /*  @PostMapping("/home/")
    public String seeWeather(@ModelAttribute CountryWeather countryWeather){
        weatherService.getCountryWeather("Denmark");
        return "home";
    } */

}