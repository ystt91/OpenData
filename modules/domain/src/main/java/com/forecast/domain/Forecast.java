package com.forecast.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Forecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "baseDate")
    private String baseDate;

    @Column(name = "baseTime")
    private String baseTime;

    @Column(name = "category")
    private String category;

    @Column(name = "fcstDate")
    private String fcstDate;

    @Column(name = "fcstTime")
    private String fcstTime;

    @Column(name = "fcstValue")
    private String fcstValue;

    @Column(name = "nx")
    private Integer nx;

    @Column(name = "ny")
    private Integer ny;


}
