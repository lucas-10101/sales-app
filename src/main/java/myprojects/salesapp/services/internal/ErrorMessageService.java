package myprojects.salesapp.services.internal;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import myprojects.salesapp.models.enums.ErrorType;

@Service
public class ErrorMessageService {

    protected ResponseEntity<Map<String, Object>> createBaseErrorMessage(HttpStatus responseStatus, ErrorType errorType, Map<String, Object> extendProperties) {

        Map<String, Object> response = new HashMap<>(2);

        response.put("time", LocalDateTime.now());
        response.put("type", errorType.name());

        extendProperties.forEach((key, value) -> {
            response.putIfAbsent(key, value);
        });

        return ResponseEntity.status(responseStatus).body(response);

    }

    public ResponseEntity<Map<String, Object>> createValidationErrorMessage(List<String> validationErrors) {

        Map<String, Object> response = new HashMap<>(1);
        response.put("errors", validationErrors);

        return createBaseErrorMessage(HttpStatus.BAD_REQUEST, ErrorType.VALIDATION, response);
    }
}
