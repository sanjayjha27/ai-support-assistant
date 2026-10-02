package com.sanjay.aisupport.model;
import jakarta.validation.constraints.NotBlank;
public record ChatRequest(@NotBlank String message) {}