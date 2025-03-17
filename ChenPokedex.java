import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ChenPokedex {
    private Map<String, ChenPokemon> chenPokemonMap;
    private List<ChenPokemon> chenUserCollection;
    private Scanner scanner;

    public ChenPokedex(ChenMapFactory factory) {
        this.chenPokemonMap = factory.createMap();
        this.chenUserCollection = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addChenPokemon(String name, String type1, String ability) {
        chenPokemonMap.put(name, new ChenPokemon(name, type1, ability));
    }

    public boolean addChenPokemonToUserCollection(String name) {
        if (!chenPokemonMap.containsKey(name)) {
            return false; // El Pokémon no existe en la base de datos
        }
        ChenPokemon pokemon = chenPokemonMap.get(name);
        if (chenUserCollection.contains(pokemon)) {
            return false; // El Pokémon ya está en la colección del usuario
        } else {
            chenUserCollection.add(pokemon);
            return true;
        }
    }

    public ChenPokemon getChenPokemon(String name) {
        return chenPokemonMap.get(name); // Devuelve el Pokémon o null si no existe
    }

    public void showChenUserCollectionByType() {
        chenUserCollection.stream()
            .sorted(Comparator.comparing(p -> p.type1))
            .forEach(System.out::println);
    }

    public void showAllChenPokemonByType() {
        chenPokemonMap.values().stream()
            .sorted(Comparator.comparing(p -> p.type1))
            .forEach(System.out::println);
    }

    public void showChenPokemonByAbility(String ability) {
        chenPokemonMap.values().stream()
            .filter(p -> p.ability.equalsIgnoreCase(ability))
            .forEach(System.out::println);
    }

    public void startMenu() {
        while (true) {
            System.out.println("\n--- Menú de ChenPokedex ---");
            System.out.println("1. Agregar Pokémon a la colección del usuario");
            System.out.println("2. Mostrar datos de un Pokémon");
            System.out.println("3. Mostrar colección del usuario ordenada por tipo");
            System.out.println("4. Mostrar todos los Pokémon ordenados por tipo");
            System.out.println("5. Mostrar Pokémon por habilidad");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (option) {
                case 1 -> {
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    String name = scanner.nextLine();
                    if (addChenPokemonToUserCollection(name)) {
                        System.out.println("Pokémon agregado correctamente.");
                    } else {
                        System.out.println("Error: Pokémon no existe o ya está en la colección.");
                    }
                }
                case 2 -> {
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    String name = scanner.nextLine();
                    ChenPokemon pokemon = getChenPokemon(name);
                    if (pokemon != null) {
                        System.out.println(pokemon);
                    } else {
                        System.out.println("Pokémon no encontrado.");
                    }
                }
                case 3 -> showChenUserCollectionByType();
                case 4 -> showAllChenPokemonByType();
                case 5 -> {
                    System.out.print("Ingrese la habilidad: ");
                    String ability = scanner.nextLine();
                    showChenPokemonByAbility(ability);
                }
                case 6 -> {
                    System.out.println("Saliendo de ChenPokedex...");
                    return;
                }
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    public static void main(String[] args) {
        ChenMapFactory factory = new ChenHashMapFactory(); // Puede cambiarse a otra implementación
        ChenPokedex pokedex = new ChenPokedex(factory);

        // Cargar algunos Pokémon de prueba
        pokedex.addChenPokemon("Pikachu", "Electric", "Static");
        pokedex.addChenPokemon("Charmander", "Fire", "Blaze");
        pokedex.addChenPokemon("Squirtle", "Water", "Torrent");
        pokedex.addChenPokemon("Bulbasaur", "Grass", "Overgrow");

        // Iniciar menú interactivo
        pokedex.startMenu();
    }
}
