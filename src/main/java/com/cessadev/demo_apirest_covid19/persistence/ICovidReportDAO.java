package com.cessadev.demo_apirest_covid19.persistence;

import com.cessadev.demo_apirest_covid19.model.CovidReportEntity;

import java.util.List;

public interface ICovidReportDAO {

    List<CovidReportEntity> findAll();

    void save(CovidReportEntity report);
}
