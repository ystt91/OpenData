package com.forecast.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    APPLICATION_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "어플리케이션 에러"), // 01
    DB_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "기관 데이터베이스 에러"),      //02
    NO_DATA_ERROR(HttpStatus.BAD_REQUEST, "NX, NY 값 전달 에러"),            //03
    HTTP_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "HTTP 에러"),              //04
    SERVICE_TIME_OUT(HttpStatus.REQUEST_TIMEOUT, "서비스 타임아웃"),          //05
    INVALID_REQUEST_PARAMETER_ERROR(HttpStatus.BAD_REQUEST,
            "유효하지 않은 요청 파라미터 에러"),                                  //10
    NO_MANDATORY_REQUEST_PARAMETERS_ERROR(HttpStatus.BAD_REQUEST,
            "필수 요청 파라미터 없음 에러"),                                    //11
    NO_OPENAPI_SERVICE_ERROR(HttpStatus.NOT_FOUND, "오픈API 서비스 없음 에러"), //12
    SERVICE_ACCESS_DENIED_ERROR(HttpStatus.FORBIDDEN, "서비스 접근 거부"),     //20
    LIMITED_NUMBER_OF_SERVICE_REQUESTS_EXCEEDS_ERROR(HttpStatus.TOO_MANY_REQUESTS,
            "서비스 요청 제한 초과 에러"),                                       //22
    NOT_REGISTERED_SERVICE_KEY(HttpStatus.FORBIDDEN, "등록되지 않은 서비스 키"), //30
    EXPIRED_KEY(HttpStatus.FORBIDDEN, "기한 만료된 서비스 키"),                  //31
    UNREGISTERED_IP_ERROR(HttpStatus.FORBIDDEN, "등록되지 않은 IP 에러"),        //32
    UNSIGNED_CALL_ERROR(HttpStatus.FORBIDDEN, "서명되지 않은 호출 에러"),         //33
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 에러");         //99


    private final HttpStatus httpStatus;
    private final String message;

}
