/**
 * 
 */
package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.PokemonSearchParams;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Pokemon;
import com.example.demo.repository.PokemonRepository;
import com.example.demo.service.PokemonService;

/**
 * @author Yuliya
 *
 */

@Service
public class PokemonServiceImpl implements PokemonService{
	
	private PokemonRepository pokemonRepository;
	
	/**
	 * @param pokemonRepository
	 */
	public PokemonServiceImpl(PokemonRepository pokemonRepository) {
		super();
		this.pokemonRepository = pokemonRepository;
	}

	@Override
	public List<Pokemon> getAllPokemons() {
		return pokemonRepository.findAll();
	}

	@Override
	public Pokemon getPokemonById(int id) {

		Pokemon existPokemon;
		Pokemon result = pokemonRepository.findById(id).get();
		existPokemon = result;
		
		List<Pokemon> pokemonEvolutions = new ArrayList<>();		
		
		while(result.getEvolution() > 0) {
			result = pokemonRepository.findById(result.getEvolution()).get();
			pokemonEvolutions.add(result);
		}

		existPokemon.setEvolutions(pokemonEvolutions);
		
		return existPokemon;
	}

	@Override
	public List<Pokemon> getFavouritePokemons() {
		
		return pokemonRepository.findAll().stream().filter(p -> p.getIsFavourite() == true).collect(Collectors.toList());
	}

	@Override
	public List<Pokemon> searchBySpeciesAndType(PokemonSearchParams pokemonSearchParams) {
		
		if(pokemonSearchParams.getSpecies() == null || pokemonSearchParams.getSpecies().isBlank()) {
			return pokemonRepository.findAll().stream()					
					.filter(pokemon -> pokemon.getTypes().stream().anyMatch(type -> type.getId() == pokemonSearchParams.getTypeId())) .collect(Collectors.toList());
		} else if (pokemonSearchParams.getTypeId() < 1) {
			return pokemonRepository.findAll().stream()
					.filter(p -> p.getSpecies().toLowerCase().contains(pokemonSearchParams.getSpecies().toLowerCase())).collect(Collectors.toList());
		} else {
			return pokemonRepository.findAll().stream()
					.filter(p -> p.getSpecies().toLowerCase().contains(pokemonSearchParams.getSpecies().toLowerCase()))
					.filter(pokemon -> pokemon.getTypes().stream().anyMatch(type -> type.getId() == pokemonSearchParams.getTypeId())) .collect(Collectors.toList());
		}		
		
	}



	@Override
	public Pokemon updatePokemon(int id) {
		
		if(pokemonRepository.existsById(id)) {
			Pokemon existingPokemon = getPokemonById(id);
			
			existingPokemon.setIsFavourite(!existingPokemon.getIsFavourite());
			pokemonRepository.save(existingPokemon);
			
			return existingPokemon;	
		} else {
			throw new ResourceNotFoundException("Pokemon", "Id", id);
		}
			
	}

}
