package com.cessadev.demo_apirest_covid19.utils.mapper.implementation;

import com.cessadev.demo_apirest_covid19.model.CovidReportEntity;
import com.cessadev.demo_apirest_covid19.model.dto.CovidReportDTO;
import com.cessadev.demo_apirest_covid19.utils.mapper.interfaces.ICovidReportMapper;
import org.springframework.stereotype.Component;

@Component
public class CovidReportMapper implements ICovidReportMapper {

    @Override
    public CovidReportDTO toDto(CovidReportEntity entity) {
        if (entity == null) {
            return null;
        }
        return new CovidReportDTO(
                entity.getCountry(),
                entity.getCases(),
                entity.getDeaths(),
                entity.getRecovered()
        );
    }
}
