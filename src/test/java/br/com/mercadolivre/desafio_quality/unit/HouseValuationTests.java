package br.com.mercadolivre.desafio_quality.unit;

import br.com.mercadolivre.desafio_quality.entities.Prop;
import br.com.mercadolivre.desafio_quality.entities.Room;
import br.com.mercadolivre.desafio_quality.service.HouseValuationService;
import br.com.mercadolivre.desafio_quality.service.exceptions.DataIntegrityException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class HouseValuationTests {

    @Autowired
    HouseValuationService service;

    static Room room1, room2, room3;
    static List<Room> roomList;
    static Prop prop;

    @BeforeAll
    public static void setup() {
        room1 = new Room("Bedroom", 10.0, 5.0);
        room2 = new Room("Bathroom", 2.0, 2.0);
        room3 = new Room("Kitchen", 5.0, 5.0);
        roomList = new ArrayList<>();
        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);

        prop = new Prop();
        prop.setProp_name("Casa A");
        prop.setProp_district("Beverly Hills");
        prop.setRooms(roomList);
    }

    @Test
    public void testCalculatePropArea() {
        //act
        Double calculatedArea = service.calculatePropArea(prop);

        //assert
        Assertions.assertEquals(79.0, calculatedArea);
    }

    @Test
    public void testVerifyPropDistrict() {
        //act
        String propDistrict = null;
        try {
            propDistrict = service.propDistrict(prop);
        } catch(Exception e) {
            e.printStackTrace();
            Assertions.fail("Nao deveria lancar excecao");
        }

        //assert
        Assertions.assertEquals("Beverly Hills", propDistrict);
    }

    @Test
    public void testVerifyPropDistrictShouldThrowException() throws DataIntegrityException{
        prop.setProp_district("Beverly Hi");

        String propDistrict = null;
        try {
            propDistrict = service.propDistrict(prop);
            Assertions.fail();
        } catch(Exception e) {
            Assertions.assertEquals("Bairro inválido", e.getMessage());
        }
    }

    @Test
    public void testCalculateGreatestRoom(){
        //act
        Room greatestRoom = null;
        try {
            greatestRoom = service.calculateGreatestRoom(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //assert
        Assertions.assertEquals(room1, greatestRoom);
    }

    @Test
    public void testCalculateRoomSize() {
        //act
        Double roomSize1 = room1.calculateRoomSize();
        Double roomSize2 = room2.calculateRoomSize();
        Double roomSize3 = room3.calculateRoomSize();

        //assert
        Assertions.assertEquals(50.0, roomSize1);
        Assertions.assertEquals(4.0, roomSize2);
        Assertions.assertEquals(25.0, roomSize3);
    }

}