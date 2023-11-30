package com.chatGPT.ChatGpt.integraion.with.spring.boot.applicatioin.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class OpenAiChatGptConfig {
    @Value("${openai.chatgtp.api.key}")
    private String OpenaiApiKey;

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + OpenaiApiKey);
            return execution.execute(request, body);
        });
        return restTemplate;
    }
}
