package learning.APITesting;import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CompleteApiTest {

    // 1. SIMPLE GET REQUEST

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



    // 2. VALIDATE STATUS CODE

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



    // 3. PRINT ALL HEADERS

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



    // 4. EXTRACT JSON FIELDS USING JSONPATH

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



    // 5. GET REQUEST USING QUERY PARAMETERS

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



    // 6. POST REQUEST (CREATE USER)

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



    // 7. PUT REQUEST (UPDATE FULL USER)

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



    // 8. PATCH REQUEST (PARTIAL UPDATE)

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



    // 9. DELETE REQUEST

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