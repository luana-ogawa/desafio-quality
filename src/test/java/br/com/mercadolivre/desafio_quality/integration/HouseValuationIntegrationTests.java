package br.com.mercadolivre.desafio_quality.integration;

import br.com.mercadolivre.desafio_quality.entities.Prop;
import br.com.mercadolivre.desafio_quality.entities.Room;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HouseValuationIntegrationTests {

    @LocalServerPort
    private int port;

    @Test
    public void postRequest() {

        Room room1 = new Room("Bedroom", 10.0, 5.0);
        Room room2 = new Room("Bathroom", 2.0, 2.0);
        Room room3 = new Room("Kitchen", 5.0, 5.0);
        List<Room> roomList = new ArrayList<>();
        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);

        Prop prop = new Prop();
        prop.setProp_name("Casa A");
        prop.setProp_district("Beverly Hills");
        prop.setRooms(roomList);

        Response response = given()
                .port(this.port)
                .contentType(ContentType.JSON)
                .body(prop)
                .when()
                .post("/house-valuation")
                .then()
                .extract().response();

        Assertions.assertEquals(201, response.statusCode());
        Assertions.assertEquals("79.0", response.jsonPath().getString("totalArea"));
        Assertions.assertEquals("158000.0", response.jsonPath().getString("totalValue"));
        Assertions.assertEquals("Bedroom", response.jsonPath().getString("greatestRoom.room_name"));
        Assertions.assertEquals("10.0", response.jsonPath().getString("greatestRoom.room_width"));
        Assertions.assertEquals("5.0", response.jsonPath().getString("greatestRoom.room_length"));
        Assertions.assertEquals("Bedroom", response.jsonPath().getString("roomSizes[0].room_name"));
        Assertions.assertEquals("50.0", response.jsonPath().getString("roomSizes[0].room_size"));
        Assertions.assertEquals("Bathroom", response.jsonPath().getString("roomSizes[1].room_name"));
        Assertions.assertEquals("4.0", response.jsonPath().getString("roomSizes[1].room_size"));
        Assertions.assertEquals("Kitchen", response.jsonPath().getString("roomSizes[2].room_name"));
        Assertions.assertEquals("25.0", response.jsonPath().getString("roomSizes[2].room_size"));

    }

}
