package exercise;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Test;
import static org.junit.Assert.*;

public class ServiceIntegrationTest {
    
    public ServiceIntegrationTest() {
    }
    
    @Test
    public void serverIsRunning() {
        given().when().get("http://localhost:8084/ExamPrep4v2TestAndMockingJunitMockito/index.html").then().statusCode(200);
    }
    
    @Test
    public void restIsWorking() {
        given()
            .when()
            .get("http://localhost:8084/ExamPrep4v2TestAndMockingJunitMockito/api/jokes/getourstolenjoke/")
            .then()
            .statusCode(200)
             .body("reference",equalTo("http://api.icndb.com/"));
    }
}
