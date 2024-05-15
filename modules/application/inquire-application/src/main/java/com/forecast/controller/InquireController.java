package com.forecast.controller;

import com.forecast.dto.inquire.ForecastDto;
import com.forecast.service.InquireService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class InquireController {

    private final InquireService inquireService;

    @GetMapping("/inquire")
    @ResponseBody
    public ResponseEntity<List<ForecastDto>> getForecastInfo() {

        //DB 조회
        ResponseEntity<List<ForecastDto>> forecasts = inquireService.getForecasts();

        return forecasts;

    }

}
