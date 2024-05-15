package com.forecast.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
@RequiredArgsConstructor
public class ErrorResponse {

    private final HttpStatus status;
    private final String code;
    private final String message;

    public static ResponseEntity<ErrorResponse> responseExceptionEntity(CustomException e) {
        return ResponseEntity
                        .status(e.getErrorCode().getHttpStatus())
                        .body(ErrorResponse.builder()
                        .status(e.getErrorCode().getHttpStatus())
                        .code(e.getErrorCode().name())
                        .message(e.getErrorCode().getMessage())
                        .build());
    }
}
