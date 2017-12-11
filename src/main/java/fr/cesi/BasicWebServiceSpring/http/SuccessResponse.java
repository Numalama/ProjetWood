package fr.cesi.BasicWebServiceSpring.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.HashMap;
import org.json.JSONObject;

/**
 *
 * @author valentin
 */
@JsonInclude(Include.NON_EMPTY)
public class SuccessResponse implements Response {

    private Object message;
    private HashMap data = new HashMap<String, Object>();

    public SuccessResponse(Object message) {
        this.message = message;
    }

    public SuccessResponse() {
    }

//    public Object getMessage() {
//        return message;
//    }

    public Object getData() {
        if (data.isEmpty()) {
            return message;
        } else {
            return data;
        }
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public void setData(HashMap values) {
        this.data = values;
    }

    public void addData(String key, Object value) {
        this.data.put(key, value);
    }

    @Override
    public String toString() {
        if (this.message != null) {
            return new JSONObject(this.message)
                    .toString();
        } else {
            return new JSONObject(this.data)
                    .toString();
        }
    }

    public JSONObject toJson() {
        if (this.message != null) {
            return new JSONObject(this.message);
        } else {
            return new JSONObject(this.data);
        }
    }
}
