package br.com.mercadolivre.desafio_quality.dtos;

import br.com.mercadolivre.desafio_quality.entities.Room;

public class RoomSizeDTO {

    private String room_name;
    private Double room_size;

    public RoomSizeDTO() {
    }

    public RoomSizeDTO(String room_name, Double room_size) {
        this.room_name = room_name;
        this.room_size = room_size;
    }

    public RoomSizeDTO(Room room) {
        this.room_name = room.getRoom_name();
        this.room_size = room.calculateRoomSize();
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public Double getRoom_size() {
        return room_size;
    }

    public void setRoom_size(Double room_size) {
        this.room_size = room_size;
    }
}
