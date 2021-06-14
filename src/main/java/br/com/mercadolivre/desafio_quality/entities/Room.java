package br.com.mercadolivre.desafio_quality.entities;

import br.com.mercadolivre.desafio_quality.entities.groups.FirstOrder;
import br.com.mercadolivre.desafio_quality.entities.groups.SecondOrder;
import br.com.mercadolivre.desafio_quality.entities.groups.ThirdOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.GroupSequence;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@GroupSequence({Room.class, FirstOrder.class, SecondOrder.class, ThirdOrder.class})
public class Room implements Comparable<Room>{

    @NotBlank(message = "O campo não pode estar vazio.", groups = FirstOrder.class)
    @Size(max = 30, message = "O comprimento do cômodo não pode exceder 30 caracteres.", groups = ThirdOrder.class)
    @Pattern(regexp = "^[A-Z].*$", message = "O nome do cômodo deve começar com uma letra maiúscula.", groups = SecondOrder.class)
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
