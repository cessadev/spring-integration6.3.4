package com.cessadev.demo_apirest_covid19.service;

import com.cessadev.demo_apirest_covid19.model.dto.CovidReportDTO;

import java.util.List;

public interface ICovidReportService {

    List<CovidReportDTO> findAllReports();

    void saveReport(CovidReportDTO reportDTO);

    void sendAlert(CovidReportDTO reportDTO);
}
