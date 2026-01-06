package learning.APITesting;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.*;

public class ClimateTest {
    @Test
    void getCityClimateDetails(){
        RestAssured.baseURI="https://demoqa.com/utilities/weather/city";
        RequestSpecification req = RestAssured.given();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the city name: ");
        String n = sc.nextLine();
        
        Response res = req.request(Method.GET, "/"+n);
        String output = res.body().asString();
        System.out.println(output + "\t" + res.statusCode());

        Headers headers = res.headers();
        headers.forEach(System.out::println);
    }
}