package com.forecast.service;

import com.forecast.api.ForecastApi;
import com.forecast.domain.Forecast;
import com.forecast.dto.sync.ForecastItemDto;
import com.forecast.dto.sync.ForecastRequestDto;
import com.forecast.repository.ForecastRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SyncService {

    private final ForecastRepository forecastRepository;

    private final ForecastApi forecastApi;

    private final ModelMapper modelMapper;

    @Transactional
    public void sync(ForecastRequestDto forecastRequestDto) {

        //GET 조회
        List<ForecastItemDto> forecastItemDtoList = forecastApi.getForecastItemsDto(forecastRequestDto);

        //DB 데이터 삭제
        forecastRepository.deleteAll();

        //DTO -> Entity
        List<Forecast> forecastList = forecastItemDtoList.stream()
                .map(forecastItemdto -> modelMapper.map(forecastItemdto, Forecast.class))
                .collect(Collectors.toList());
        
        //DB 저장
        forecastRepository.saveAll(forecastList);

    }

}
