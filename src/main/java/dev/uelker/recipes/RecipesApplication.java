package dev.uelker.recipes;

import dev.uelker.recipes.client.RecipeClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class RecipesApplication {
    @Value("${baseUrl}")
    private String baseUrl;

    public static void main(String[] args) {
        SpringApplication.run(RecipesApplication.class, args);
    }


    @Bean
    RecipeClient recipeClient() {
        WebClient webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Accept","application/json")
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
                .build();

        return factory.createClient(RecipeClient.class);
    }
}
