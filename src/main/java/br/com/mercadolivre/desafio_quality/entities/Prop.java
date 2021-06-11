package br.com.mercadolivre.desafio_quality.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prop {

    @NotBlank(message = "O nome da propriedade não pode estar vazio.")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    @Pattern(regexp = "^[A-z ]+$", message = "O nome da propriedade deve começar com uma letra maiúscula.") //corrigir
    private String prop_name;

    @NotBlank(message = "O bairro não pode estar vazio.")
    @Size(max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres.")
    private String prop_district;

    @Valid
    private List<Room> rooms;

}
