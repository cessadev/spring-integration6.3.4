package com.cessadev.demo_apirest_covid19.controller.v1;

import com.cessadev.demo_apirest_covid19.model.dto.CovidReportDTO;
import com.cessadev.demo_apirest_covid19.service.ICovidReportService;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/covid")
public class CovidReportController {

    private final ICovidReportService covidReportService;
    private final MessageChannel covidInputChannel;

    public CovidReportController(ICovidReportService covidReportService, MessageChannel covidInputChannel) {
        this.covidReportService = covidReportService;
        this.covidInputChannel = covidInputChannel;
    }

    /*
    * http://localhost:8080/covid/reports
    */
    @GetMapping("/reports")
    public List<CovidReportDTO> getAllReports() {
        return covidReportService.findAllReports();
    }

    /*
     * http://localhost:8080/covid/trigger
     */
    @GetMapping("/trigger")
    public String triggerCovidFlow() {
        // We send an empty message to the input channel to start the flow.
        boolean sent = covidInputChannel.send(MessageBuilder.withPayload("").build());

        if (sent) {
            return "Flow running";
        } else {
            return "Error when executing the flow";
        }
    }
}
