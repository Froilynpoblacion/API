package API.API;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class AppTest {

    @Test
    public void testing1post() {
        JSONObject var = new JSONObject();

        var.put("name", "Ryan");
        var.put("job", "IT");

        System.out.println(var.toJSONString());

        ((Object) given().
                body(var.toJSONString()).
        when()).
                var ("https://reqres.in/api/users").
        then().
            statusCode(201);
    }
    
    @Test
    public void testing2patch() {
        JSONObject var = new JSONObject();

        var.put("name", "Ryan");
        var.put("job", "IT");

        System.out.println(var.toJSONString());

        given().
                body(var.toJSONString()).
        when().
                patch ("https://reqres.in/api/users/2").
        then().
            statusCode(200);
    }
    
    @Test
    public void testing3get() {

        when().
                get ("https://reqres.in/api/users/2").
        then().
            statusCode(200).log().all();
    }
    
    @Test
    public void testing4delete() {

        when().
                delete ("https://reqres.in/api/users/2").
        then().
            statusCode(204).log().all();
    }

}