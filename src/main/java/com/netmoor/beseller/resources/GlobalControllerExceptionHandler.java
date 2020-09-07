package com.netmoor.beseller.resources;

import com.netmoor.beseller.dto.ErrorCode;
import com.netmoor.beseller.dto.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

/**
 * GlobalControllerExceptionHandler.
 *
 * @author Nikolay_Batov
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorDto> handleNotFound(RuntimeException ex) {
        return new ResponseEntity<>(new ErrorDto(ErrorCode.NOT_FOUND, ex.getMessage()), HttpStatus.NOT_FOUND);
    }


    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex,
                                                         HttpHeaders headers,
                                                         HttpStatus status,
                                                         WebRequest request) {
        return handleExceptionInternal(ex, getErrorValidation(ex.getBindingResult()), headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        return handleExceptionInternal(ex, getErrorValidation(ex.getBindingResult()), headers, HttpStatus.BAD_REQUEST, request);
    }

    private ErrorDto getErrorValidation(BindingResult bindingResult) {
        ErrorDto errorDto = ErrorDto.builder()
                .errorCode(ErrorCode.VALIDATION_ERROR)
                .message("")
                .build();

        bindingResult.getFieldErrors().forEach(error -> 
            errorDto.addValidationError(error.getObjectName(),
                    new ErrorDto.ValidationError(
                            error.getField(),
                            error.getDefaultMessage(),
                            error.getRejectedValue())
            )
        );

        return errorDto;
    }
}
