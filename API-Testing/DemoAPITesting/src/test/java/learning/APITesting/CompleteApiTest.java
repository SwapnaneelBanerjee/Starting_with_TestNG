package learning.APITesting;import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CompleteApiTest {

    // Basic Get

    @Test
    public void simpleGetWeather() {

        RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";

        Response resp = RestAssured
                            .given()
                            .when()
                            .get("/Kolkata");

        System.out.println("Status Code: " + resp.getStatusCode());
        System.out.println("Response Body: " + resp.asString());
    }



    // Check Status

    @Test
    public void validateStatusCode() {

        RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";

        Response resp = RestAssured
                            .given()
                            .when()
                            .get("/Delhi");

        assertEquals(resp.getStatusCode(), 200);
        System.out.println("Status Line: " + resp.getStatusLine());
    }



    // Print all

    @Test
    public void printAllHeaders() {

        RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";

        Response resp = RestAssured
                            .given()
                            .when()
                            .get("/Delhi");

        Headers headers = resp.getHeaders();

        for (Header h : headers) {
            System.out.println(h.getName() + " : " + h.getValue());
        }
    }



    // Extract json fields using json path

    @Test
    public void extractJsonFields() {

        RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";

        Response resp = RestAssured
                            .given()
                            .when()
                            .get("/Hyderabad");

        JsonPath json = resp.jsonPath();

        String city = json.get("City");
        String temp = json.get("Temperature");

        System.out.println("City: " + city);
        System.out.println("Temperature: " + temp);

        assertEquals(city, "Hyderabad");
    }



    // Get Request using Param Requests

    @Test
    public void queryParamRequest() {

        RestAssured.baseURI = "https://samples.openweathermap.org/data/2.5";

        Response resp = RestAssured
                            .given()
                            .queryParam("q", "London,UK")
                            .queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8")
                            .when()
                            .get("/weather");

        System.out.println("Status Code: " + resp.getStatusCode());
        System.out.println("Response Body: " + resp.asString());

        assertEquals(resp.asString().contains("London"), true);
    }



    // Post Requests

    @Test
    public void postRequestExample() {

        RestAssured.baseURI = "https://reqres.in/api";

        JSONObject req = new JSONObject();
        req.put("name", "John");
        req.put("job", "QA Engineer");

        Response resp = RestAssured
                            .given()
                            .header("Content-Type", "application/json")
                            .body(req.toJSONString())
                            .when()
                            .post("/users");

        System.out.println("Status Code: " + resp.getStatusCode());
        System.out.println("Response Body: " + resp.asString());

        assertEquals(resp.getStatusCode(), 201);
    }



    // Put Request

    @Test
    public void putRequestExample() {

        RestAssured.baseURI = "https://reqres.in/api";

        JSONObject req = new JSONObject();
        req.put("name", "John Updated");
        req.put("job", "Senior Automation Engineer");

        Response resp = RestAssured
                            .given()
                            .header("Content-Type", "application/json")
                            .body(req.toJSONString())
                            .when()
                            .put("/users/2");

        System.out.println("Status Code: " + resp.getStatusCode());
        System.out.println("Response Body: " + resp.asString());

        assertEquals(resp.getStatusCode(), 200);
    }



    // Patch Request

    @Test
    public void patchRequestExample() {

        RestAssured.baseURI = "https://reqres.in/api";

        JSONObject req = new JSONObject();
        req.put("job", "Lead QA Engineer");

        Response resp = RestAssured
                            .given()
                            .header("Content-Type", "application/json")
                            .body(req.toJSONString())
                            .when()
                            .patch("/users/2");

        System.out.println("Status Code: " + resp.getStatusCode());
        System.out.println("Response Body: " + resp.asString());

        assertEquals(resp.getStatusCode(), 200);
    }



    // Delete
    @Test
    public void deleteRequestExample() {

        RestAssured.baseURI = "https://reqres.in/api";

        Response resp = RestAssured
                            .given()
                            .when()
                            .delete("/users/2");

        System.out.println("Status Code: " + resp.getStatusCode());

        assertEquals(resp.getStatusCode(), 204);
    }
}