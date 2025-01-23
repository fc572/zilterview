package fc572.api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class FakeApi {
    private final String baseUrl;

    public FakeApi(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Response postToFake() {
        return given()
                .baseUri(baseUrl)
                .contentType("application/json")
                .when()
                .post("/api/resource");
    }

    public Response getFake(String id) {
        return given()
                .baseUri(baseUrl)
                .when()
                .get("/api/resource/" + id);
    }
}
