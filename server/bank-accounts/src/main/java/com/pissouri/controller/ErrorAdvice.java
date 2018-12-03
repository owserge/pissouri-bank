package com.pissouri.controller;

import com.pissouri.dto.ResponseDto;
import com.pissouri.dto.ResponseStatusCode;
import com.pissouri.service.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("unused")
@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler({Exception.class, Throwable.class, RuntimeException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseDto exception(HttpServletRequest request, Exception exception) {

        return new ResponseDto<>()
                .setStatusCode(ResponseStatusCode.SERVER_ERROR)
                .setStatusText("Kaboom");
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseDto resourceNotFound(HttpServletRequest request, ResourceNotFoundException exception) {

        return new ResponseDto<>()
                .setStatusCode(ResponseStatusCode.CLIENT_ERROR)
                .setStatusText("Not found");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseDto illegalArgument(HttpServletRequest request, IllegalArgumentException exception) {

        return new ResponseDto<>()
                .setStatusCode(ResponseStatusCode.CLIENT_ERROR)
                .setStatusText(exception.getMessage());
    }
}
