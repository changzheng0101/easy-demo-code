package com.weixiao;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;

@QuarkusTest
public class UserResourceTest {

    @Test
    public void testUserLifecycle() {
        // 1. 测试创建用户 (POST)
        User user = new User();
        user.name = "Quarkus User";
        user.email = "test@example.com";

        Integer userId = given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("name", is("Quarkus User"))
                .extract()
                .path("id");

        // 2. 测试获取所有用户 (GET)
        given()
                .when()
                .get("/users")
                .then()
                .log().all()
                .statusCode(200)
                .body("size()", greaterThan(0));

        // 3. 测试修改用户 (PUT)
        String updatedName = "New Name";
        user.name = updatedName;

        given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .put("/users/" + userId)
                .then()
                .statusCode(200)
                .body("name", is(updatedName));

        // 4. 测试删除用户 (DELETE)
        given()
                .when()
                .delete("/users/" + userId)
                .then()
                .statusCode(204);
    }

    @Test
    public void testSearchUser() {
        given()
                .queryParam("name", "TestRobot")
                .queryParam("email", "bot")
                .when()
                .get("/users/search")
                .then()
                .log().all()
                .statusCode(200)
                .body("size()", is(1))
                .body("[0].name", is("TestRobot"));
    }
}