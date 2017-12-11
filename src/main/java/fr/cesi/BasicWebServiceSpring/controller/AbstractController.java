/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cesi.BasicWebServiceSpring.controller;

import fr.cesi.BasicWebServiceSpring.http.ErrorResponse;
import fr.cesi.BasicWebServiceSpring.http.Response;
import fr.cesi.BasicWebServiceSpring.http.SuccessResponse;
import javax.servlet.ServletException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Valentin Lafranca
 */
@ControllerAdvice
public abstract class AbstractController {

    public ResponseEntity<Response> responseError(String message) {
        ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, message);
        return new ResponseEntity<Response>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Response> responseSuccess(Object message) {
        SuccessResponse res = new SuccessResponse(message);
        return new ResponseEntity<Response>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Response> responseSuccess(String key, String message) {
        SuccessResponse res = new SuccessResponse();
        res.addData(key, message);
        return new ResponseEntity<Response>(res, HttpStatus.OK);
    }
}
