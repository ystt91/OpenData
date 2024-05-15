package com.forecast.dto.sync;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
public class ForecastRequestDto {

    private Integer pageNo;                 // 페이지 번호

    private Integer numOfRows;              // 한 페이지 결과 수

    @DateTimeFormat(pattern = "yyyyMMdd")
    private String baseDate;                // 발표 일자

    @DateTimeFormat(pattern = "HHmm")
    private String baseTime;                // 발표 시각

    private Integer nx;                     // x 좌표

    private Integer ny;                     // y 좌표
}

