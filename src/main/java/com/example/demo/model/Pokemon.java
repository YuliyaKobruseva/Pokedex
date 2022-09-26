/**
 * 
 */
package com.example.demo.model;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.JoinColumn;



/**
 * @author Yuliya
 * 
 */

@Entity
@Table(name="pokemons")
public class Pokemon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "species", nullable = false )
	private String species;
	
	@Column(name = "cp")
	private int cp;
	
	@Column(name = "hp")
	private int hp;
	
	@Column(name = "min_weight")
	private Double minWeight;
	
	@Column(name = "max_weight")
	private Double maxWeight;
	
	@Column(name = "min_height")
	private Double minHeight;
	
	@Column(name = "max_height")
	private Double maxHeight;
	
	@Column(name = "favourite")
	private Boolean isFavourite;
	
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "pokemon_types_relations", 
        joinColumns = { @JoinColumn(name = "pokemon_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "type_id") }
    )
	private Set<PokemonType> types;
    
    @Column(name = "evolution", nullable = true)
	private int evolution;
    
    @JsonInclude()
    @Transient
    @ElementCollection
    private List<Pokemon> evolutions;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * @param species the species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 * @return the cp
	 */
	public int getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(int cp) {
		this.cp = cp;
	}

	/**
	 * @return the hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * @param hp the hp to set
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * @return the minWeight
	 */
	public Double getMinWeight() {
		return minWeight;
	}

	/**
	 * @param minWeight the minWeight to set
	 */
	public void setMinWeight(Double minWeight) {
		this.minWeight = minWeight;
	}

	/**
	 * @return the maxWeight
	 */
	public Double getMaxWeight() {
		return maxWeight;
	}

	/**
	 * @param maxWeight the maxWeight to set
	 */
	public void setMaxWeight(Double maxWeight) {
		this.maxWeight = maxWeight;
	}

	/**
	 * @return the minHeight
	 */
	public Double getMinHeight() {
		return minHeight;
	}

	/**
	 * @param minHeight the minHeight to set
	 */
	public void setMinHeight(Double minHeight) {
		this.minHeight = minHeight;
	}

	/**
	 * @return the maxHeight
	 */
	public Double getMaxHeight() {
		return maxHeight;
	}

	/**
	 * @param maxHeight the maxHeight to set
	 */
	public void setMaxHeight(Double maxHeight) {
		this.maxHeight = maxHeight;
	}

	/**
	 * @return the isFavourite
	 */
	public Boolean getIsFavourite() {
		return isFavourite;
	}

	/**
	 * @param isFavourite the isFavourite to set
	 */
	public void setIsFavourite(Boolean isFavourite) {
		this.isFavourite = isFavourite;
	}

	/**
	 * @return the types
	 */
	public Set<PokemonType> getTypes() {
		return types;
	}

	/**
	 * @param types the types to set
	 */
	public void setTypes(Set<PokemonType> types) {
		this.types = types;
	}

	/**
	 * @return the evolution
	 */
	public int getEvolution() {
		return evolution;
	}

	/**
	 * @param evolution the evolution to set
	 */
	public void setEvolution(int evolution) {
		this.evolution = evolution;
	}

	/**
	 * @return the evolutions
	 */
	public List<Pokemon> getEvolutions() {
		return evolutions;
	}

	/**
	 * @param evolutions the evolutions to set
	 */
	public void setEvolutions(List<Pokemon> evolutions) {
		this.evolutions = evolutions;
	}

}
