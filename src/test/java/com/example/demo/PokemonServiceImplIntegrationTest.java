/**
 * 
 */
package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.dto.PokemonSearchParams;
import com.example.demo.enums.PokemonTypes;
import com.example.demo.model.Pokemon;
import com.example.demo.model.PokemonType;
import com.example.demo.service.PokemonService;

/**
 * @author Yuliya
 *
 */


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = PokedexApplication.class)
public class PokemonServiceImplIntegrationTest {

	@MockBean
	private PokemonService pokemonService;

	@Test
	@DisplayName("Get All Pokemons ")
	void getAllPokemonsTest() throws Exception {
		Pokemon pokemon = getPokemon();
		List<Pokemon> pokemons = new ArrayList<>();
		pokemons.add(pokemon);
		given(pokemonService.getAllPokemons()).willReturn(pokemons);
		List<Pokemon> result = pokemonService.getAllPokemons();
		assertEquals(result.size(), 1);
	}

	@Test
	@DisplayName("Get Favourite Pokemons ")
	void getFavouritePokemonsTest() throws Exception {
		Pokemon pokemon = getPokemon();
		List<Pokemon> pokemons = new ArrayList<>();
		pokemons.add(pokemon);
		given(pokemonService.getFavouritePokemons()).willReturn(new ArrayList<Pokemon>());
		List<Pokemon> result = pokemonService.getFavouritePokemons();
		assertEquals(result.size(), 0);
	}

	@Test
	@DisplayName("Get Pokemon by Id ")
	public void testGetPokemonById() throws Exception {
		Pokemon pokemon = getPokemon();
		given(pokemonService.getPokemonById(1)).willReturn(pokemon);
		Pokemon result = pokemonService.getPokemonById(1);
		assertEquals(result.getId(), 1);
	}

	@Test
	@DisplayName("Search Pokemons by filters")
	void searchPokemonByFilters() throws Exception {
		Pokemon pokemon = getPokemon();
		PokemonSearchParams pokemonSearchParams = getPokemonSearchParams();
		List<Pokemon> pokemons = new ArrayList<>();
		pokemons.add(pokemon);
		given(pokemonService.searchBySpeciesAndType(pokemonSearchParams)).willReturn(pokemons);
		List<Pokemon> result = pokemonService.searchBySpeciesAndType(pokemonSearchParams);
		assertEquals(result.size(), 1);
	}

	private Pokemon getPokemon() {

		Pokemon pokemon = new Pokemon();
		pokemon.setId(1);
		pokemon.setSpecies("Gaterpie");
		pokemon.setCp(478);
		pokemon.setHp(698);
		pokemon.setMinWeight(2.1);
		pokemon.setMaxWeight(2.9);
		pokemon.setMinHeight(0.1);
		pokemon.setMaxHeight(0.3);
		pokemon.setIsFavourite(false);
		pokemon.setTypes(getPokemonTypes());

		return pokemon;
	}

	private PokemonSearchParams getPokemonSearchParams() {

		PokemonSearchParams pokemonSearchParams = new PokemonSearchParams();
		pokemonSearchParams.setSpecies("Gat");
		pokemonSearchParams.setTypeId(3);

		return pokemonSearchParams;
	}
	
	private Set<PokemonType> getPokemonTypes() {
		
		Set<PokemonType> pokemonTypes = new HashSet<>();
		PokemonType pokemonType = new PokemonType();
		pokemonType.setId(12);
		pokemonType.setType(PokemonTypes.BUG.toString());
		pokemonTypes.add(pokemonType);
		return pokemonTypes;
	}
}
