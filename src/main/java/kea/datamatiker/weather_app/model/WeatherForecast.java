package kea.datamatiker.weather_app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



@Entity
public class WeatherForecast implements Serializable
{
    // variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToOne
    @JoinColumn(columnDefinition = "weatherId")
    private List<WeatherInfo> entries = new ArrayList<>();


    // No args constructor
    public WeatherForecast() {
    }

    //  args constructor
    public WeatherForecast(String name, List<WeatherInfo> entries) {
        this.name = name;
        this.entries = entries;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {

        return this.name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public List<WeatherInfo> getEntries() {

        return this.entries;
    }

    public void setEntries(List<WeatherInfo> entries) {

        this.entries = entries;
    }

}

