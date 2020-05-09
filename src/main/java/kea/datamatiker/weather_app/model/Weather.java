package kea.datamatiker.weather_app.model;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Table (name= "weather")
public class Weather {

   // variables
   // primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private double pressure ;
    private int humidity;
    private double speed;
    private String name;
    private Date date;

    // No args default constructor
    public Weather()
    {
    }

    //args constructor
    public Weather(double temp, int id, double feels_like,
                   double temp_min, double temp_max, double pressure, int humidity, double speed, String name,Date date ) {
        this.temp        = temp;
        this.id          = id;
        this.feels_like  = feels_like;
        this.temp_min    = temp_min;
        this.temp_max    = temp_max;
        this.pressure    = pressure;
        this.humidity    = humidity;
        this.speed       = speed;
        this.name        = name;
        this.date        = date;
    }

    // Getters and setters
    public double getTemperature() {
        return temp;
    }

    public void setTemperature(double temp) {
        this.temp = temp;
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

    public double getWindspeed() {
        return speed;
    }

    public void setWindspeed(double windspeed) {
        this.speed = windspeed;
    }

    public String getName() {
        name.trim();
        name.toUpperCase();
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

     public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
