package kea.datamatiker.weather_app.model;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Id;
import java.util.List;
import java.util.Map;

@Entity
@Table (name= "weather_info")
public class WeatherInfo implements Serializable {

     // variables
    // primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int weatherId;
    private double temperature;
    private String weatherIcon;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private double pressure ;
    private int humidity;
    private String wind;


    // JPA relation
    @JoinColumn(name = "WeatherId")
    @OneToOne(fetch = FetchType.EAGER)
    private Weather weather;





    // No args constructor
    public WeatherInfo() {
    }

    //  args constructor

    public WeatherInfo(double temperature, int weatherId, String weatherIcon, double feels_like,
                       double temp_min, double temp_max, double pressure, int humidity, String wind) {
        this.temperature = temperature;
        this.weatherId = weatherId;
        this.weatherIcon = weatherIcon;
        this.feels_like = feels_like;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wind = wind;
    }

    // Getters and setters
    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }



    //methods

    public String getFahrenheitTemperature()
    {
        double fahrenheitTemp = (this.temperature * 1.8) - 459.67;
        return String.format("%4.2f", fahrenheitTemp);
        // The format specifier "%4.2f" indicates that a floating point number is displayed in a total of
        // 4 character spaces, including 2 digits after the decimal.
    }

    public String getCelsiusTemperature()
    {
        double celsiusTemp = this.temperature - 273.15;
        return String.format("%4.2f", celsiusTemp);
    }
}


