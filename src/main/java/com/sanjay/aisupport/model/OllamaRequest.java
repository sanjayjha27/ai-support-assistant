package com.sanjay.aisupport.model;
public record OllamaRequest(String model, String prompt, boolean stream) {}