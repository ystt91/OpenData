package com.forecast.dto.sync;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ForecastResponse {

    private ForecastHeader header;
    private ForecastBody body;

}
