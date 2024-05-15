package com.forecast.service;

import com.forecast.domain.Forecast;
import com.forecast.dto.inquire.ForecastDto;
import com.forecast.repository.ForecastRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class InquireService {

    private final ForecastRepository forecastRepository;

    private final ModelMapper modelMapper;

    public ResponseEntity<List<ForecastDto>> getForecasts() {

        //DB 조회
        List<Forecast> forecasts = forecastRepository.findAll();

        //204 코드 반환
        if (forecasts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        //ENTITY -> DTO
        List<ForecastDto> forecastList = forecasts.stream()
                .map(forecast -> modelMapper.map(forecast, ForecastDto.class))
                .toList();

        return ResponseEntity.ok(forecastList);

    }

}
