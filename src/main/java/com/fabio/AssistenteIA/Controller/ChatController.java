package com.fabio.AssistenteIA.Controller;

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
    public ResponseEntity<String> perguntar(@RequestBody String prompt) {

        if(prompt == null || prompt.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Prompt não pode ser vázio");
        }

        String resposta = chatClient.prompt()
                .user(prompt)
                .call()
                .content();

        return ResponseEntity.ok(resposta);
    }

}