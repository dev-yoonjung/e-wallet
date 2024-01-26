package vvithnne.ewallet.membership.adapter.in.web.advice;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vvithnne.ewallet.membership.adapter.in.web.dto.response.ErrorResponse;
import vvithnne.ewallet.common.exception.BusinessException;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ErrorResponse> handleBindException(ConstraintViolationException exception) {
        log.error("Occurred constraint violation exception: {}", exception.getMessage());

        List<String> errorMessages = Arrays.stream(exception.getMessage().split(","))
                .map(String::trim)
                .toList();

        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.BAD_REQUEST, errorMessages);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(BusinessException exception) {
        log.error("Occurred business exception: {}", exception.getMessage());

        List<String> errorMessages = List.of(exception.getMessage());
        HttpStatus httpStatus = HttpStatus.valueOf(exception.getStatus());
        ErrorResponse errorResponse = ErrorResponse.of(httpStatus, errorMessages);

        return ResponseEntity
                .status(httpStatus)
                .body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    protected  ResponseEntity<ErrorResponse> handleException(Exception exception) {
        log.error("Occurred exception: {}", exception.getMessage());

        List<String> errorMessages = List.of(exception.getMessage());
        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, errorMessages);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }

}
