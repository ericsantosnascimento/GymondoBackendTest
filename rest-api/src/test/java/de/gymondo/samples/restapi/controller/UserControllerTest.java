package de.gymondo.samples.restapi.controller;

import de.gymondo.samples.restapi.config.MvcConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class})
@WebAppConfiguration
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    public void list_users_returns_john_in_the_payload() {

        given()
                .standaloneSetup(userController)
                .get("/api/v1/users")
                .then()
                .statusCode(200)
                .body(containsString("id\":1,\"name\":\"John\",\"age\":16,\"gender\":\"male\",\"subscriptions\":[{\"id\":1,\"name\":\"1 month"));
    }

    @Test
    public void fetch_user_john_return_expected_payload() {

        given()
                .standaloneSetup(userController)
                .get("/api/v1/users/1")
                .then()
                .statusCode(200)
                .body(containsString("id\":1,\"name\":\"John\",\"age\":16,\"gender\":\"male\",\"subscriptions\":[{\"id\":1,\"name\":\"1 month"));
    }

    @Test
    public void fetch_user_john_subscriptions_return_expected_payload() {

        given()
                .standaloneSetup(userController)
                .get("/api/v1/users/1/subscriptions")
                .then()
                .statusCode(200)
                .body(containsString("id\":1,\"name\":\"1 month\",\"expirationDate\":{\"year\":2018"));
    }
}