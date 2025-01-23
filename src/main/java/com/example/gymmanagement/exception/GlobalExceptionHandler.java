package com.example.gymmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GymManagementExeption.class)
    public ResponseEntity<ErrorResponse> handleGymManagementException(GymManagementExeption ex) {
        // Obtenemos el código de error del enum
        ErrorCode errorCode = ex.getErrorCode();

        // Mapeamos el ErrorCode a un HttpStatus
        HttpStatus httpStatus;
        switch (errorCode) {
            case RESOURCE_NOT_FOUND:
                httpStatus = HttpStatus.NOT_FOUND;
                break;
            case INVALID_INPUT:
                httpStatus = HttpStatus.BAD_REQUEST;
                break;
            case DUPLICATE_RESOURCE:
                httpStatus = HttpStatus.CONFLICT;
                break;
            default:
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
        }

        // Construimos la respuesta de error
        ErrorResponse errorResponse = new ErrorResponse(
                errorCode.getCode(), // "RESOURCE_NOT_FOUND", "INVALID_INPUT", etc.
                ex.getMessage()      // Mensaje detallado
        );

        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    // (Opcional) Manejo genérico de excepciones no esperadas
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ErrorCode.INTERNAL_SERVER_ERROR.getCode(),
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
