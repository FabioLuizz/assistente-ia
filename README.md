# Assistente IA com Spring Boot + Google Gemini

API RESTful de assistente inteligente em **processo de desenvolvimento**, utilizando Spring Boot e integração com o modelo Gemini via Spring AI.

O objetivo é criar um assistente conversacional moderno, com possibilidade futura de integração com múltiplos modelos de IA (Gemini, Grok... etc.).

### Tecnologias Atuais
- Java 21
- Spring Boot 4.0.3
- Spring AI (Google GenAI)
- APIs RESTful
- ChatClient

### Funcionalidades Atuais
- Endpoint `/api/chat/perguntar` para conversas com o Gemini
- Integração nativa com Google Gemini 2.5-flash
- Tratamento básico de prompts

### Em Desenvolvimento
- Suporte a múltiplos modelos de IA (multi-LLM)
- Roteamento inteligente entre modelos
- Upload de arquivos (PDF) para contexto (RAG)
- Dockerização
- Deploy na AWS
- Histórico de conversas

### Como Rodar Localmente

1. Clone o repositório
2. Configure sua chave no `application.properties`:
   ```properties
   spring.ai.google.genai.api-key=SUA_CHAVE_AQUI
3. Rode o projeto `mvn spring-boot:run`
4. Teste o endpoint:
      POST `http://localhost:8080/api/chat/perguntar`
      Body `(raw text): Explique o que é Spring Boot`
