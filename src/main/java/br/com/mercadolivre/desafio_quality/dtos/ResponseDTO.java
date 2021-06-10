package br.com.mercadolivre.desafio_quality.dtos;

import br.com.mercadolivre.desafio_quality.entities.Room;

import java.util.List;

public class ResponseDTO {

    private Double totalArea;
    private Double totalValue;
    private Room greatestRoom;
    private List<RoomSizeDTO> roomSizes;

    public ResponseDTO() {
    }

    public ResponseDTO(Double totalArea, Double totalValue, Room greatestRoom, List<RoomSizeDTO> roomSizes) {
        this.totalArea = totalArea;
        this.totalValue = totalValue;
        this.greatestRoom = greatestRoom;
        this.roomSizes = roomSizes;
    }

    public Double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Double totalArea) {
        this.totalArea = totalArea;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Room getGreatestRoom() {
        return greatestRoom;
    }

    public void setGreatestRoom(Room greatestRoom) {
        this.greatestRoom = greatestRoom;
    }

    public List<RoomSizeDTO> getRoomSizes() {
        return roomSizes;
    }

    public void setRoomSizes(List<RoomSizeDTO> roomSizes) {
        this.roomSizes = roomSizes;
    }
}
