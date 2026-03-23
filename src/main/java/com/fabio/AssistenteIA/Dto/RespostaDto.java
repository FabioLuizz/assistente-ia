package com.fabio.AssistenteIA.Dto;

import jakarta.validation.constraints.NotBlank;

public record RespostaDto(

        String resposta,
        String modelo

) {
}
