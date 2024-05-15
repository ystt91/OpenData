package com.forecast.api;

import com.forecast.dto.sync.*;
import com.forecast.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static com.forecast.exception.ErrorCode.*;
import static com.forecast.important.Important.SERVICE_KEY;
import static com.forecast.important.Important.SERVICE_URL;

@Component
@RequiredArgsConstructor
@Slf4j
public class ForecastApi {

    private final RestTemplate restTemplate;

    public List<ForecastItemDto> getForecastItemsDto(ForecastRequestDto forecastRequestDto) {

        //URI
        String forecastUri = getForecastUri(forecastRequestDto);

        //역직렬화 response부터 시작
        ResponseEntity<ForecastResponseDto> responseEntity =
                restTemplate.getForEntity(forecastUri, ForecastResponseDto.class);


        //예외처리
        checkException(responseEntity);

        return responseEntity.getBody().getResponse().getBody().getItems().getItem();

    }

    //URI 획득 메서드
    private String getForecastUri(ForecastRequestDto forecastRequestDto) {
        return UriComponentsBuilder.fromHttpUrl(SERVICE_URL)
                .queryParam("serviceKey", SERVICE_KEY)
                .queryParam("numOfRows", forecastRequestDto.getNumOfRows())
                .queryParam("pageNo", forecastRequestDto.getPageNo())
                .queryParam("dataType", "JSON")
                .queryParam("base_date", forecastRequestDto.getBaseDate())
                .queryParam("base_time", forecastRequestDto.getBaseTime())
                .queryParam("nx", forecastRequestDto.getNx())
                .queryParam("ny", forecastRequestDto.getNy())
                .build()
                .toString();
    }

    private void checkException(ResponseEntity<ForecastResponseDto> responseEntity){
        ForecastHeader header = responseEntity.getBody().getResponse().getHeader();
        String resultCode = header.getResultCode();

            switch (resultCode) {
                case "00": return;
                case "01": throw new CustomException(APPLICATION_ERROR);
                case "02": throw new CustomException(DB_ERROR);
                case "03": throw new CustomException(NO_DATA_ERROR);
                case "04": throw new CustomException(HTTP_ERROR);
                case "05": throw new CustomException(SERVICE_TIME_OUT);
                case "10": throw new CustomException(INVALID_REQUEST_PARAMETER_ERROR);
                case "11": throw new CustomException(NO_MANDATORY_REQUEST_PARAMETERS_ERROR);
                case "12": throw new CustomException(NO_OPENAPI_SERVICE_ERROR);
                case "20": throw new CustomException(SERVICE_ACCESS_DENIED_ERROR);
                case "22": throw new CustomException(LIMITED_NUMBER_OF_SERVICE_REQUESTS_EXCEEDS_ERROR);
                case "30": throw new CustomException(NOT_REGISTERED_SERVICE_KEY);
                case "31": throw new CustomException(EXPIRED_KEY);
                case "32": throw new CustomException(UNREGISTERED_IP_ERROR);
                case "33": throw new CustomException(UNREGISTERED_IP_ERROR);
                default : throw new CustomException(UNKNOWN_ERROR);
            }

    }

}
