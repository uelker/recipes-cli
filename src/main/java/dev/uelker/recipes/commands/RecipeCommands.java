package dev.uelker.recipes.commands;

import dev.uelker.recipes.client.RecipeClient;
import dev.uelker.recipes.model.Recipe;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Arrays;
import java.util.stream.Collectors;

@ShellComponent
public class RecipeCommands {

    private final RecipeClient recipeClient;

    public RecipeCommands(RecipeClient recipeClient) {
        this.recipeClient = recipeClient;
    }

    @ShellMethod(key="turkish", value="List a random turkish recipe")
    public String getTurkish() {
        Recipe[] recipes = recipeClient.getTurkish();
        Recipe recipe = getRandomRecipe(recipes);
        return getOutputFormat(recipe);
    }



    @ShellMethod(key="german", value="List a random german recipe")
    public String getGerman() {
        Recipe[] recipes = recipeClient.getGerman();
        Recipe recipe = getRandomRecipe(recipes);
        return getOutputFormat(recipe);
    }

    @ShellMethod(key="italian", value="List a random italian recipe")
    public String getItalian() {
        Recipe[] recipes = recipeClient.getItalian();
        Recipe recipe = getRandomRecipe(recipes);
        return getOutputFormat(recipe);
    }

    @ShellMethod(key="japanes", value="List a random japanes recipe")
    public String getJapanes() {
        Recipe[] recipes = recipeClient.getJapanes();
        Recipe recipe = getRandomRecipe(recipes);
        return getOutputFormat(recipe);
    }

    private static String getOutputFormat(Recipe recipe) {
        StringBuilder sb = new StringBuilder();
        sb.append("Recipe: ").append(recipe.name());
        sb.append("\n");
        sb.append("Ingredients:").append("\n - ").append(Arrays.stream(recipe.ingredients()).collect(Collectors.joining("\n - ")));
        sb.append("\n");
        sb.append("Steps:").append("\n - ").append(Arrays.stream(recipe.steps()).collect(Collectors.joining("\n - ")));

        return sb.toString();
    }

    private static Recipe getRandomRecipe(Recipe[] recipes) {
        int random = (int) (Math.random() * recipes.length);
        Recipe recipe = recipes[random];

        return recipe;
    }
}
