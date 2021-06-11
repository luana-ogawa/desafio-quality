package br.com.mercadolivre.desafio_quality.dtos;

import br.com.mercadolivre.desafio_quality.entities.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomSizeDTO {

    private String room_name;
    private Double room_size;

    public RoomSizeDTO(Room room) {
        this.room_name = room.getRoom_name();
        this.room_size = room.calculateRoomSize();
    }
}
