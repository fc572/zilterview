package fc572.api;

import fc572.config.Configuration;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FakeApiTest {
    private static FakeApi todoApi;

    @BeforeAll
    static void setup() {
        todoApi = new FakeApi(Configuration.getBaseUrl());
    }

    @Test
    void postToFakeTest() {

        Response postResponse = todoApi.postToFake();
        assertEquals(201, postResponse.getStatusCode());
        String todoId = postResponse.jsonPath().getString("id");

        Response getResponse = todoApi.getFake(todoId);
        assertEquals(200, getResponse.getStatusCode());
        assertEquals("Sample data associated with ID 12345", getResponse.body().jsonPath().get("message"));
    }

    @Test
    void getErrorMessage() {
        Response getResponse = todoApi.getFake("2345");
        assertEquals(404, getResponse.getStatusCode());
        assertEquals("Resource with ID 2345 not found", getResponse.body().jsonPath().getString("error"));
    }
}