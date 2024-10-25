package com.cessadev.demo_apirest_covid19.persistence.implementation;

import com.cessadev.demo_apirest_covid19.model.CovidReportEntity;
import com.cessadev.demo_apirest_covid19.persistence.ICovidReportDAO;
import com.cessadev.demo_apirest_covid19.persistence.repository.CovidReportRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CovidReportImplDAO implements ICovidReportDAO {

    private final CovidReportRepository covidReportRepository;

    public CovidReportImplDAO(CovidReportRepository covidReportRepository) {
        this.covidReportRepository = covidReportRepository;
    }

    @Override
    public List<CovidReportEntity> findAll() {
        return covidReportRepository.findAll();
    }

    @Override
    public void save(CovidReportEntity report) {
        covidReportRepository.save(report);
    }
}
