package myprojects.salesapp.controllers.exception;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import myprojects.salesapp.services.internal.ErrorMessageService;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @Autowired
    private ErrorMessageService errorMessageService;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        List<String> errors = new LinkedList<>();
        for (var error : e.getAllErrors())
            errors.add(error.getDefaultMessage());

        return errorMessageService.createValidationErrorMessage(errors);
    }
}
