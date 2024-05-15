package com.forecast.dto.sync;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ForecastItemsDto {

    private List<ForecastItemDto> Item;

}
