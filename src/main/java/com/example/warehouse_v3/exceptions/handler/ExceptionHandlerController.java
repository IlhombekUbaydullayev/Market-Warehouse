package com.example.warehouse_v3.exceptions.handler;

import com.example.warehouse_v3.dto.responses.AppErrorDto;
import com.example.warehouse_v3.dto.responses.DataDto;
import com.example.warehouse_v3.exceptions.AppBadRequestException;
import com.example.warehouse_v3.exceptions.ItemNotFoundException;
import com.example.warehouse_v3.exceptions.UserAlreadyExistException;
import com.example.warehouse_v3.exceptions.UserNotFoundException;
import jakarta.persistence.NonUniqueResultException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerController {

    @ExceptionHandler({
            AppBadRequestException.class, ListenerExecutionFailedException.class,
            NullPointerException.class,
            IllegalArgumentException.class,
            NonUniqueResultException.class,
            UserAlreadyExistException.class
    })
    public ResponseEntity<DataDto<AppErrorDto>> handleBadRequestException(RuntimeException e) {
        return new ResponseEntity<>(new DataDto<>(new AppErrorDto(e.getMessage(), HttpStatus.BAD_REQUEST)), HttpStatus.OK);
    }

//    @ExceptionHandler({BadCredentialsException.class})
//    public ResponseEntity<DataDto<AppErrorDto>> handleTokenException(RuntimeException e) {
//        log.error(" error : {}, couse: [{}]", ApiMessages.UNAUTHORIZED, ExceptionUtils.getRootCauseMessage(e));
//        return new ResponseEntity<>(new DataDto<>(new AppErrorDto(e.getMessage(), HttpStatus.UNAUTHORIZED)), HttpStatus.OK);
//    }


//    @ExceptionHandler({InvalidTokenException.class, PermissionDeniedException.class})
//    public ResponseEntity<DataDto<AppErrorDto>> handleForbiddenException(RuntimeException e) {
//        log.error(" error : {}, couse: [{}]", ApiMessages.FORBIDDEN, ExceptionUtils.getRootCauseMessage(e));
//        return new ResponseEntity<>(new DataDto<>(new AppErrorDto(e.getMessage(), HttpStatus.FORBIDDEN)), HttpStatus.OK);
//    }

    @ExceptionHandler({UserNotFoundException.class, ItemNotFoundException.class})
    public ResponseEntity<DataDto<AppErrorDto>> handleNotFoundException(RuntimeException e) {
        return new ResponseEntity<>(new DataDto<>(new AppErrorDto(e.getMessage(), HttpStatus.NOT_FOUND)), HttpStatus.OK);
    }

//    @ExceptionHandler({
//            SQLException.class,
//            PSQLException.class})
//    public ResponseEntity<DataDto<AppErrorDto>> handleSqlException(RuntimeException e) {
//        log.error(" error : {}, couse: [{}]", ApiMessages.INTERNAL_SERVER_ERROR, ExceptionUtils.getStackTrace(e));
//        return new ResponseEntity<>(new DataDto<>(new AppErrorDto(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)), HttpStatus.OK);
//    }
//
//    @ExceptionHandler({ServiceUnavailableException.class})
//    public ResponseEntity<DataDto<AppErrorDto>> handleServiceUnavaibleException(RuntimeException e) {
//        return new ResponseEntity<>(new DataDto<>(new AppErrorDto(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)), HttpStatus.OK);
//    }
//
//    @ExceptionHandler({JsonParserException.class, CuntomIOException.class})
//    public ResponseEntity<DataDto<AppErrorDto>> handleJsonParsingException(RuntimeException e) {
//        return new ResponseEntity<>(new DataDto<>(new AppErrorDto(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)), HttpStatus.OK);
//    }
//
//    @ExceptionHandler({InternalServerError.class, RollbackException.class})
//    public ResponseEntity<DataDto<AppErrorDto>> handleInternalServerErrorException(RuntimeException e) {
//        log.error(" error : {}, couse: [{}]", ApiMessages.INTERNAL_SERVER_ERROR, ExceptionUtils.getRootCauseMessage(e));
//        return new ResponseEntity<>(new DataDto<>(new AppErrorDto(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)), HttpStatus.OK);
//    }
}
