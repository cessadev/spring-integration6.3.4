package com.cessadev.demo_apirest_covid19.configuration;

import com.cessadev.demo_apirest_covid19.model.dto.CovidReportDTO;
import com.cessadev.demo_apirest_covid19.service.ICovidReportService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableIntegration
public class CovidIntegrationConfig {

    private final ICovidReportService covidReportService;

    public CovidIntegrationConfig(ICovidReportService covidReportService) {
        this.covidReportService = covidReportService;
    }

    @Bean
    public MessageChannel covidInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel covidResponseChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow covidReportFlow() {
        return f -> f.channel(covidInputChannel())  // Listen on covidInputChannel
                .handle(httpOutboundGateway()); // Send HTTP request
    }

    @Bean
    public MessageHandler httpOutboundGateway() {
        HttpRequestExecutingMessageHandler handler =
                new HttpRequestExecutingMessageHandler("https://disease.sh/v3/covid-19/countries/Colombia");
        handler.setHttpMethod(HttpMethod.GET);
        handler.setExpectedResponseType(String.class);
        handler.setOutputChannel(covidResponseChannel());  // Channel to process the response
        return handler;
    }

    @ServiceActivator(inputChannel = "covidResponseChannel")
    public void processCovidReport(String response) {
        CovidReportDTO report = transformToCovidReportDTO(response);
        covidReportService.saveReport(report);

        if (report.cases() > 100000) {
            covidReportService.sendAlert(report);
        }
    }

    private CovidReportDTO transformToCovidReportDTO(String response) {
        try {
            JsonNode root = new ObjectMapper().readTree(response);
            return new CovidReportDTO(
                    root.get("country").asText(),
                    root.get("cases").asInt(),
                    root.get("deaths").asInt(),
                    root.get("recovered").asInt()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error transforming the report: " + e.getMessage(), e);
        }
    }
}
