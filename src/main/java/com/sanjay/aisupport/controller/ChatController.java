package com.sanjay.aisupport.controller;

import com.sanjay.aisupport.model.ChatRequest;
import com.sanjay.aisupport.model.ChatResponse;
import com.sanjay.aisupport.service.AiService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private final AiService aiService;

    public ChatController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping
    public ChatResponse chat(@Valid @RequestBody ChatRequest request) {
        return new ChatResponse(aiService.answer(request.message()), aiService.getModel());
    }
}