package me.dio.parking.controller;

import io.restassured.RestAssured;
import me.dio.parking.controller.dto.ParkingCreateDTO;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerIT {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest() {
        RestAssured.port = randomPort;
    }

    @Test
    void whenFindAllThenCheckResult() {
        RestAssured.given()
                .when()
                .get("/parking")
                .then()
                .statusCode(200);
    }

    @Test
    void whenCreateThenCheckIsCreated() {

        var createDTO = new ParkingCreateDTO();
        createDTO.setLicense("ABC1234");
        createDTO.setState("SP");
        createDTO.setModel("Gol");
        createDTO.setColor("Branco");

        RestAssured.given()
                .contentType("application/json")
                .body(createDTO)
                .when()
                .post("/parking")
                .then()
                .statusCode(201)
                .body("license", Matchers.equalTo("ABC1234"))
                .body("state", Matchers.equalTo("SP"))
                .body("model", Matchers.equalTo("Gol"))
                .body("color", Matchers.equalTo("Branco"));
    }
}