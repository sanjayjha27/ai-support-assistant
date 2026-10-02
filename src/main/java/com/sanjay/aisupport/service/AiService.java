package com.sanjay.aisupport.service;

import com.sanjay.aisupport.model.OllamaRequest;
import com.sanjay.aisupport.model.OllamaResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AiService {
    private final RestClient client;
    private final String model;

    public AiService(RestClient client, @Value("${ai.model:qwen3:1.7b}") String model) {
        this.client = client;
        this.model = model;
    }

    public String answer(String message) {
        String prompt = "You are a helpful customer support assistant. "
                + "Answer clearly and briefly. User: " + message;

        OllamaResponse result = client.post()
                .uri("/api/generate")
                .body(new OllamaRequest(model, prompt, false))
                .retrieve()
                .body(OllamaResponse.class);

        if (result == null || result.response() == null) {
            throw new IllegalStateException("No response received from Ollama");
        }
        return result.response().trim();
    }

    public String getModel() {
        return model;
    }
}