package learn.pokedex.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PokemonRepositoryTest {

    @Autowired
    PokemonRepository repository;

    @Test
    void shouldFindPokemon() {
        var pokemon = repository.findAll();
        assertTrue(pokemon != null && pokemon.size() > 0);
    }

}