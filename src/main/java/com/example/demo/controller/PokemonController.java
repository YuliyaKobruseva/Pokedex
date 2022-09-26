/**
 * 
 */
package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PokemonSearchParams;
import com.example.demo.model.Pokemon;
import com.example.demo.service.PokemonService;

/**
 * @author Yuliya
 *
 */

@RestController
@RequestMapping("/pokedex")
public class PokemonController {

	private PokemonService pokemonService;

	/**
	 * @param pokemonService
	 */
	public PokemonController(PokemonService pokemonService) {
		super();
		this.pokemonService = pokemonService;
	}
	
	@GetMapping("/all")
	public List<Pokemon> getAllPokemons(){
		return pokemonService.getAllPokemons();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pokemon> getPokemonById(@PathVariable("id") int pokemonId){
		return new ResponseEntity<Pokemon>(pokemonService.getPokemonById(pokemonId), HttpStatus.OK);
	}
	
	@GetMapping("/favourite")
	public ResponseEntity<List<Pokemon>> getFavouritePokemons() {
		return new ResponseEntity<List<Pokemon>>(pokemonService.getFavouritePokemons(), HttpStatus.OK);
	}
	
	@PutMapping("/favourite/{id}")
	public ResponseEntity<Pokemon> updateFavouriteById(@PathVariable("id") int pokemonId){
		return new ResponseEntity<Pokemon>(pokemonService.updatePokemon(pokemonId), HttpStatus.OK);
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<Pokemon>> searchByNameAndType(@RequestBody PokemonSearchParams pokemonSearchParams) {
		return new ResponseEntity<List<Pokemon>>(pokemonService.searchBySpeciesAndType(pokemonSearchParams), HttpStatus.OK);
	}
	
}
