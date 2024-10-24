package com.cessadev.demo_apirest_covid19.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "covid_reports")
public class CovidReport {

    @Id
    private String country;
    private int cases;
    private int deaths;
    private int recovered;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CovidReport that)) return false;
        return cases == that.cases && deaths == that.deaths && recovered == that.recovered && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, cases, deaths, recovered);
    }

    @Override
    public String toString() {
        return "CovidReport{" +
                "country='" + country + '\'' +
                ", cases=" + cases +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                '}';
    }
}
