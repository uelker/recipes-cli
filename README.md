# Recipes CLI

The Recipes CLI is a command-line application that allows users to view random recipes from various cuisines such as German, Italian, Turkish, and Japanese. The recipes are fetched from an S3 bucket using the HTTP interface provided by Spring Framework v6.

## Setup

1. Clone the repository: `git clone https://github.com/uelker/recipes-cli.git`
2. Start the shell: ` ./mvnw spring-boot:run`
3. The command `help` will display a list of available commands.

```console
shell:> help
AVAILABLE COMMANDS

Built-In Commands
       help: Display help about available commands
       stacktrace: Display the full stacktrace of the last error.
       clear: Clear the shell screen.
       quit, exit: Exit the shell.
       history: Display or save the history of previously run commands
       version: Show version info
       script: Read and execute commands from a file.

Recipe Commands
       german: List a random german recipe
       turkish: List a random turkish recipe
       japanes: List a random japanes recipe
       italian: List a random italian recipe
```

4. The command `german` will display a random German recipe.

```console
shell:>german
Recipe: Kartoffelpuffer (Potato Pancakes)
Ingredients:
 - 4 potatoes, peeled and grated
 - 1 onion, grated
 - 2 eggs
 - 1/4 cup flour
 - 1/2 tsp salt
 - 1/4 tsp black pepper
 - Vegetable oil for frying
Steps:
 - Combine the grated potatoes and onion in a large bowl.
 - Add the eggs, flour, salt, and black pepper.
 - Stir until well combined.
 - Heat 1/4 inch of vegetable oil in a large skillet over medium-high heat.
 - Drop spoonfuls of the potato mixture into the hot oil.
 - Fry for 2-3 minutes on each side or until golden brown.
 - Drain on paper towels.
 - Serve hot with sour cream or applesauce.
```

4. It is also possible to create a native image using GraalVM. The command `./mvnw -Pnative native:compile` will create a native image in the `target` directory. The native image can be executed using the command `./target/recipes`.
