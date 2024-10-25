package com.cessadev.demo_apirest_covid19.service.implementation;

import com.cessadev.demo_apirest_covid19.model.CovidReportEntity;
import com.cessadev.demo_apirest_covid19.model.dto.CovidReportDTO;
import com.cessadev.demo_apirest_covid19.persistence.ICovidReportDAO;
import com.cessadev.demo_apirest_covid19.service.ICovidReportService;
import com.cessadev.demo_apirest_covid19.utils.mapper.interfaces.ICovidReportMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CovidReportService implements ICovidReportService {

    private final ICovidReportDAO covidReportDAO;
    private final ICovidReportMapper covidReportMapper;

    public CovidReportService(ICovidReportDAO covidReportDAO, ICovidReportMapper covidReportMapper) {
        this.covidReportDAO = covidReportDAO;
        this.covidReportMapper = covidReportMapper;
    }

    @Override
    public List<CovidReportDTO> findAllReports() {
        return covidReportMapper.toDtoList(covidReportDAO.findAll());
    }

    public void saveReport(CovidReportDTO reportDTO) {
        CovidReportEntity reportEntity = reportDTO.toEntity();
        covidReportDAO.save(reportEntity);
        System.out.println("Report saved: " + reportDTO);
    }

    public void sendAlert(CovidReportDTO reportDTO) {
        System.out.println("⚠️ Alert: Critical cases in " + reportDTO.country() +
                " - Cases: " + reportDTO.cases());
    }
}
