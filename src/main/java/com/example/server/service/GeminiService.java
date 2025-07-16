package com.example.server.service;

import com.example.server.model.RequestDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String GEMINI_API_KEY;

    private final ObjectMapper mapper = new ObjectMapper();

    public String generateFromDTO(RequestDTO requestDTO) {
        try {
            String prompt = "Generate a professional resume from the following JSON. Format it into sections like Summary, Skills, Education, Projects, Experience, and Certifications:\n\n"
                    + mapper.writeValueAsString(requestDTO);

            return sendPromptToGemini(prompt);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\": \"Failed to prepare request for Gemini.\"}";
        }
    }

    private String sendPromptToGemini(String prompt) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        String requestBody = """
            {
              "contents": [
                {
                  "parts": [
                    {
                      "text": "%s"
                    }
                  ]
                }
              ]
            }
            """.formatted(escapeJson(prompt));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent"))
                .header("Content-Type", "application/json")
                .header("x-goog-api-key", GEMINI_API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return formatGeminiResponseAsJson(response.body());
    }

    private String formatGeminiResponseAsJson(String responseBody) {
        try {
            JsonNode root = mapper.readTree(responseBody);
            JsonNode textNode = root.path("candidates").path(0).path("content").path("parts").path(0).path("text");

            if (textNode.isMissingNode()) {
                return "{\"error\": \"No generated text found in Gemini response.\"}";
            }

            return mapper.createObjectNode()
                    .put("status", "success")
                    .put("model", "gemini-2.5-flash")
                    .put("generated_text", textNode.asText())
                    .toPrettyString();

        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\": \"Error parsing Gemini response.\"}";
        }
    }

    private String escapeJson(String input) {
        return input.replace("\"", "\\\"").replace("\n", "\\n");
    }
}
