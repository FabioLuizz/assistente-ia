package com.fabio.AssistenteIA.Controller;

import com.fabio.AssistenteIA.Dto.PerguntaDto;
import com.fabio.AssistenteIA.Dto.RespostaDto;
import jakarta.validation.Valid;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @PostMapping("/perguntar")
    public ResponseEntity<RespostaDto> perguntar(@RequestBody PerguntaDto dto) {

        if(dto.prompt() == null || dto.prompt().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(new RespostaDto(
                    "O prompt não pode ser vázio",
                    "GEMINI"
            ));
        }

        String resposta = chatClient.prompt()
                .user(dto.prompt())
                .call()
                .content();

        RespostaDto respostaDto = new RespostaDto(
                resposta,
                "GEMINI"
        );

        return ResponseEntity.ok(respostaDto);
    }

}