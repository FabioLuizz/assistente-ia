package com.fabio.AssistenteIA.Dto;

import jakarta.validation.constraints.NotBlank;

public record PerguntaDto(

        @NotBlank(message="O prompt não pode ser vázio")
        String prompt

) {

}
