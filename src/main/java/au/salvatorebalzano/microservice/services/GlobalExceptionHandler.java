package au.salvatorebalzano.microservice.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(BindException.class)
    public ResponseEntity<Object> handleValidationErrors(BindException ex) {
        List<ObjectError> errors = ex.getAllErrors();

        Map<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        String objectNameCap = ex.getObjectName().substring(0, 1).toUpperCase() + ex.getObjectName().substring(1);
        map.put(objectNameCap, list);

        for (ObjectError i : errors) {
            map.get(objectNameCap).add(i.getDefaultMessage());
        }

        return ResponseEntity.badRequest().body(map);
    }
}