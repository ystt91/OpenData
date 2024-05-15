package com.forecast.dto.sync;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ForecastBody {

    private String dataType;
    private ForecastItemsDto items;
    private Integer numOfRows;
    private Integer pageNo;
    private Integer totalCount;

}
