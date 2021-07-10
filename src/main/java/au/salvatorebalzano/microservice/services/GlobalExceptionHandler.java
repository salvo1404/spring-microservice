package au.salvatorebalzano.microservice.services;

import java.net.HttpURLConnection;
import java.util.*;

import au.salvatorebalzano.microservice.exceptions.PlayerNotFoundException;
import org.springframework.http.HttpStatus;
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

    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<Object> handlePlayerNotFound(PlayerNotFoundException ex) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", HttpURLConnection.HTTP_NOT_FOUND);
        map.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}