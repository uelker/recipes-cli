package dev.uelker.recipes.client;

import dev.uelker.recipes.model.Recipe;
import org.springframework.web.service.annotation.GetExchange;

public interface RecipeClient {

    @GetExchange("/turkish.json")
    Recipe[] getTurkish();

    @GetExchange("/german.json")
    Recipe[] getGerman();

    @GetExchange("/italian.json")
    Recipe[] getItalian();

    @GetExchange("/japanes.json")
    Recipe[] getJapanes();

}
