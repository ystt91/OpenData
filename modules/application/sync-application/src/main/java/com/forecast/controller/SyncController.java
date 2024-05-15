package com.forecast.controller;

import com.forecast.dto.sync.ForecastRequestDto;
import com.forecast.service.SyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SyncController {

    private final SyncService syncService;

    @PostMapping("/sync")
    public ResponseEntity<String> syncWeatherData(@RequestBody ForecastRequestDto forecastRequestDto){

        syncService.sync(forecastRequestDto);

        return ResponseEntity.ok("OK");
    }

}
