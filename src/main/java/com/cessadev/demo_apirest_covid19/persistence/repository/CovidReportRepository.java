package com.cessadev.demo_apirest_covid19.persistence.repository;

import com.cessadev.demo_apirest_covid19.model.CovidReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CovidReportRepository extends JpaRepository<CovidReport, String> {
}
