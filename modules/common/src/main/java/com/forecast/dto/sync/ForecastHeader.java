package com.forecast.dto.sync;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ForecastHeader {

    private String resultCode;
    private String resultMsg;

}
