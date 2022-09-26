/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PokemonSearchParams;
import com.example.demo.model.Pokemon;

/**
 * @author Yuliya
 *
 */
public interface PokemonService {
	
	List<Pokemon>getAllPokemons();
	List<Pokemon>getFavouritePokemons();
	List<Pokemon>searchBySpeciesAndType(PokemonSearchParams pokemonSearchParams);
	Pokemon getPokemonById(int id);
	Pokemon updatePokemon(int id);	
	
}
