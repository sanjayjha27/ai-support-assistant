# AI Support Assistant

Working Java/Spring Boot REST backend with local AI integration through Ollama.

## Requirements
- Java 17+
- Maven 3.9+
- Ollama

## Start AI
Install Ollama, then:

    ollama pull qwen3:1.7b

Make sure Ollama is running on `http://localhost:11434`.

## Start backend

    mvn spring-boot:run

Server:

    http://localhost:8080

## Test health

    GET http://localhost:8080/api/health

Expected:

    {"service":"AI Support Assistant","status":"UP"}

## Test AI

POST:

    http://localhost:8080/api/chat

JSON:

    {"message":"What is an HTTP 500 error?"}

The backend sends the request to Ollama and returns the generated answer.

## Run tests

    mvn test

## Architecture

Client -> Spring Boot Controller -> AI Service -> Ollama -> Local LLM

## Resume note

Use this as a starting working implementation. Add and test your own features before claiming it as a major resume project.