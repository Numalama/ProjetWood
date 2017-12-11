package fr.cesi.BasicWebServiceSpring.exception;

import fr.cesi.BasicWebServiceSpring.http.ErrorResponse;
import fr.cesi.BasicWebServiceSpring.http.Response;
import javax.servlet.ServletException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author valentin
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ServletException.class)
    public ResponseEntity<Response> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<Response>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
