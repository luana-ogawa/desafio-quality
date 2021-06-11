package br.com.mercadolivre.desafio_quality.unit;

import br.com.mercadolivre.desafio_quality.entities.Prop;
import br.com.mercadolivre.desafio_quality.entities.Room;
import br.com.mercadolivre.desafio_quality.service.HouseValuationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class HouseValuationTests {

    @Autowired
    HouseValuationService service;

    @Test
    public void testCalculatePropArea() {
        //arrange
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

        //act
        Double calculatedArea = service.calculatePropArea(prop);

        //assert
        Assertions.assertEquals(79.0, calculatedArea);
    }



}