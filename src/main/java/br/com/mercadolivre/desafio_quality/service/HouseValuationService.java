package br.com.mercadolivre.desafio_quality.service;

import br.com.mercadolivre.desafio_quality.dtos.RoomSizeDTO;
import br.com.mercadolivre.desafio_quality.entities.Prop;
import br.com.mercadolivre.desafio_quality.entities.Room;
import br.com.mercadolivre.desafio_quality.exceptions.ApiExceptionControllerAdvice;
import br.com.mercadolivre.desafio_quality.utils.ArithmeticUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class HouseValuationService {

    private static Map<String, Double> districtPrices = new HashMap<>();
    static {
        Map<String, Double> aMap = new HashMap<>();
        aMap.put("Bel Air", 1000.0);
        aMap.put("Beverly Hills", 2000.0);
        aMap.put("Silver Lake", 1500.0);
        aMap.put("Sun Valley", 1800.0);
        aMap.put("East Hollywood", 1900.0);
        aMap.put("Koreatown", 700.0);
        districtPrices = Collections.unmodifiableMap(aMap);
    }

    public Double calculatePropArea(Prop prop) {
        return prop.getRooms().stream()
                .map(room -> room.calculateRoomSize())
                .reduce(0.0, ArithmeticUtils :: add);
    }

    public String propDistrict(Prop prop) throws Exception {
        String propDistrict = prop.getProp_district();
        if(propDistrict == null || !districtPrices.containsKey(prop.getProp_district())) {
            throw new Exception("Bairro inválido"); //arrumar
        }
        return propDistrict;
    }

    public Double calculatePropValue(Prop prop) throws Exception {
        Double value = districtPrices.get(propDistrict(prop));
        return calculatePropArea(prop) * districtPrices.get(prop.getProp_district());
    }

    public Room calculateGreatestRoom(Prop prop) throws Exception {
        return prop.getRooms().stream()
                .max(Comparator.naturalOrder())
//                .max(Comparator.comparing(Room::calculateRoomSize))
                .orElseThrow(() -> new Exception("No room returned"));
    }

    public List<RoomSizeDTO> returnRoomsSize(Prop prop) {
        return prop.getRooms().stream()
                .map(room -> new RoomSizeDTO(room))
                .collect(Collectors.toList());
    }

}
