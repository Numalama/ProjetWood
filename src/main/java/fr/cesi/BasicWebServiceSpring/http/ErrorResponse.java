package fr.cesi.BasicWebServiceSpring.http;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;

/**
 *
 * @author valentin
 */
public class ErrorResponse implements Response {

    private HttpStatus errorCode;
    private String message;

    public ErrorResponse(HttpStatus errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
    
    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    @Override
    public String toString(){
        return new JSONObject()
                .put("error", this.message)
                .toString();
    }
}
