package br.com.mercadolivre.desafio_quality.entities;

import br.com.mercadolivre.desafio_quality.entities.groups.FirstOrder;
import br.com.mercadolivre.desafio_quality.entities.groups.SecondOrder;
import br.com.mercadolivre.desafio_quality.entities.groups.ThirdOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.GroupSequence;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@GroupSequence({Prop.class, FirstOrder.class, SecondOrder.class, ThirdOrder.class})
public class Prop {

    @NotBlank(message = "O nome da propriedade não pode estar vazio.", groups = FirstOrder.class)
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres.", groups = ThirdOrder.class)
    @Pattern(regexp = "^[A-Z].*$", message = "O nome da propriedade deve começar com uma letra maiúscula.", groups = SecondOrder.class)
    private String prop_name;

    @NotBlank(message = "O bairro não pode estar vazio.")
    @Size(max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres.")
    private String prop_district;

    @Valid
    private List<Room> rooms;

}
