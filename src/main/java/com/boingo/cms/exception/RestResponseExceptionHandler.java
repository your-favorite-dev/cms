package com.boingo.cms.exception;


import com.google.common.collect.Lists;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    public RestResponseExceptionHandler() {
        super();
    }

    // API

    // 400

    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleBadRequest(final ConstraintViolationException ex, final WebRequest request) {
        List<String> errors = Lists.newArrayList();
        //TODO add errors
        ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }

    @ExceptionHandler({ DataIntegrityViolationException.class })
    public ResponseEntity<Object> handleBadRequest(final DataIntegrityViolationException ex, final WebRequest request) {
        List<String> errors = Lists.newArrayList();
        //TODO add errors
        ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        List<String> errors = Lists.newArrayList();
        //TODO add errors
        ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        // ex.getCause() instanceof JsonMappingException, JsonParseException // for additional information later on
        return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        List<String> errors = Lists.newArrayList();
        //TODO add errors
        ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
    }

    // 404

    @ExceptionHandler(value = { EntityNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(final RuntimeException ex, final WebRequest request) {
        List<String> errors = Lists.newArrayList();
        //TODO add errors
        ApiError apiError =
                new ApiError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), errors);
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }

    // 409

    @ExceptionHandler({ InvalidDataAccessApiUsageException.class, DataAccessException.class })
    protected ResponseEntity<Object> handleConflict(final RuntimeException ex, final WebRequest request) {
        List<String> errors = Lists.newArrayList();
        //TODO add errors
        ApiError apiError =
                new ApiError(HttpStatus.CONFLICT, ex.getLocalizedMessage(), errors);
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }

    // 412

    // 500

    @ExceptionHandler({ NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class, UnsupportedOperationException.class })
    /*500*/public ResponseEntity<Object> handleInternal(final RuntimeException ex, final WebRequest request) {
        logger.error("500 Status Code", ex);
        List<String> errors = Lists.newArrayList();
        //TODO add errors
        errors.add(ex.getLocalizedMessage());
        errors.add(ex.getCause().getMessage());
        ApiError apiError =
                new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,"FUBAR" , errors);
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }

}

