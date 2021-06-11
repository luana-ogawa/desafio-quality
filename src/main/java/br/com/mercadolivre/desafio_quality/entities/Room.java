package br.com.mercadolivre.desafio_quality.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room implements Comparable<Room>{

    @NotBlank(message = "O campo não pode estar vazio.")
    @Size(max = 30, message = "O comprimento do cômodo não pode exceder 30 caracteres.")
    @Pattern(regexp = "^[A-Z].*$", message = "O nome do cômodo deve começar com uma letra maiúscula.")
    private String room_name;

    @NotNull(message = "A largura do cômodo não pode estar vazia.")
    @Max(value = 25, message = "A largura máxima permitida por cômodo é de 25 metros")
    private Double room_width;

    @NotNull(message = "O comprimento do cômodo não pode estar vazio.")
    @Max(value = 33, message = "O comprimento máximo permitido por cômodo é de 33 metros.")
    private Double room_length;

    public Double calculateRoomSize() {
        return this.room_length * this.room_width;
    }

    @Override
    public int compareTo(Room o) {
        return calculateRoomSize().compareTo(o.calculateRoomSize());
    }
}
