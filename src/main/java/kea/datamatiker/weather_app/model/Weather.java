package kea.datamatiker.weather_app.model;

import javax.persistence.Table;
import javax.persistence.*;
import javax.persistence.Id;


@Entity
@Table(name = "cities")
public class Weather extends WeatherInfo
    {

        // variables

        private String cityName;

        // primary key
        @Id
        // this annotation allows MySQL to give the next ID (IDENTITY)
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Integer city_id;
        private String main;
        private String description;
        private String icon;

        // JPA relation
        @OneToOne
        @JoinColumn(name = "weatherId")
        private WeatherInfo weatherInfo;

        @OneToOne
        @JoinColumn(name = "id")
        private WeatherForecast weatherForecast;

        // No args constructor
        public Weather(){
        }
        //  args constructor
        public Weather(String cityName, Integer id, String main, String description, String icon) {
            this.cityName = cityName;
            this.city_id = city_id;
            this.main = main;
            this.description = description;
            this.icon = icon;
        }

        // getters and setters
        public String getCityName() {
            return this.cityName;
        }

        public void setCityName(String name) {
            this.cityName = name;
        }

        public Integer getCity_idId() {
            return city_id;
        }

        public void setId(Integer city_id) {
            this.city_id = city_id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }



    }




