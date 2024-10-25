package com.cessadev.demo_apirest_covid19.model.dto;

import com.cessadev.demo_apirest_covid19.model.CovidReportEntity;

public record CovidReportDTO(
        String country,
        int cases,
        int deaths,
        int recovered
) {
    public static CovidReportDTO toDTO(CovidReportEntity report) {
        return new CovidReportDTO(
                report.getCountry(),
                report.getCases(),
                report.getDeaths(),
                report.getRecovered()
        );
    }

    public CovidReportEntity toEntity() {
        CovidReportEntity report = new CovidReportEntity();
        report.setCountry(country);
        report.setCases(cases);
        report.setDeaths(deaths);
        report.setRecovered(recovered);
        return report;
    }
}
