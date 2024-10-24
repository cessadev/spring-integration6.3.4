package com.cessadev.demo_apirest_covid19.controller.v1;

import com.cessadev.demo_apirest_covid19.service.ICovidReportService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covid")
public class CovidReportController {

    private final ICovidReportService covidReportService;

    public CovidReportController(ICovidReportService covidReportService) {
        this.covidReportService = covidReportService;
    }
}
