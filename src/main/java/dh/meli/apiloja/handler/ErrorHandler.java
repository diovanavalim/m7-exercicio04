package dh.meli.apiloja.handler;

import dh.meli.apiloja.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(DeleteException.class)
    public ResponseEntity<ExceptionDetails> deleteExceptionHandler(DeleteException e) {
        return new ResponseEntity<ExceptionDetails>(ExceptionDetails
                .builder()
                .title("Could not delete product")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(GetException.class)
    public ResponseEntity<ExceptionDetails> getExceptionHandler(GetException e) {
        return new ResponseEntity<ExceptionDetails>(ExceptionDetails
                .builder()
                .title("Could not get product")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDetails> productNotFoundExceptionHandler(ProductNotFoundException e) {
        return new ResponseEntity<ExceptionDetails>(ExceptionDetails
                .builder()
                .title("Could not find product")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(SaveException.class)
    public ResponseEntity<ExceptionDetails> saveExceptionHandler(SaveException e) {
        return new ResponseEntity<ExceptionDetails>(ExceptionDetails
                .builder()
                .title("Could not save product")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(UpdateException.class)
    public ResponseEntity<ExceptionDetails> updateExceptionHandler(UpdateException e) {
        return new ResponseEntity<ExceptionDetails>(ExceptionDetails
                .builder()
                .title("Could not update product")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
