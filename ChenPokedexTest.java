import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChenPokedexTest {
    private ChenPokedex pokedex;

    @BeforeEach
    void setup() {
        pokedex = new ChenPokedex(new ChenHashMapFactory());
        pokedex.addChenPokemon("Pikachu", "Electric", "Static");
        pokedex.addChenPokemon("Charmander", "Fire", "Blaze");
    }

    @Test
    void testAddChenPokemonToUserCollection() {
        assertTrue(pokedex.addChenPokemonToUserCollection("Pikachu"));
        assertFalse(pokedex.addChenPokemonToUserCollection("Pikachu")); // No debe repetirse
    }

    @Test
    void testGetChenPokemon() {
        assertNotNull(pokedex.getChenPokemon("Charmander"));
        assertNull(pokedex.getChenPokemon("Mew")); // No existe
    }
}
