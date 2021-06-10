package br.com.mercadolivre.desafio_quality.controller;

import br.com.mercadolivre.desafio_quality.dtos.ResponseDTO;
import br.com.mercadolivre.desafio_quality.entities.Prop;
import br.com.mercadolivre.desafio_quality.service.HouseValuationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HouseValuationController {

    @Autowired
    HouseValuationService service;

    @RequestMapping(value = "/house-valuation", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> houseValuation (@Valid @RequestBody Prop prop) throws Exception {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setTotalArea(service.calculatePropArea(prop));
        responseDTO.setTotalValue(service.calculatePropValue(prop));
        responseDTO.setGreatestRoom(service.calculateGreatestRoom(prop));
        responseDTO.setRoomSizes(service.returnRoomsSize(prop));

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

}
