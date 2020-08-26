
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fit5042_assignment.repository;

import fit5042_assignment.repository.entities.Pokemon;
import fit5042_assignment.repository.entities.User;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author shaohangyu
 */
@Remote
public interface PokemonRepository {
    /**
     * Add the pokemon being passed as parameter into the repository
     * @param pokemon
     * @throws Exception 
     */
    public void addPokemon(Pokemon pokemon) throws Exception;
    
    /**
     * Search for a pokemon by its pokemon ID
     * @param id
     * @return the pokemon found
     * @throws Exception 
     */
    public Pokemon searchPokemonById(int id) throws Exception;
    
    /**
     * Return all the pokemons in the repository
     * @return all the properties in the repository
     * @throws Exception 
     */
    public List<Pokemon> getAllPokemons() throws Exception;
    
    /**
     * Remove the pokemon, whose pokemon ID matches the one being passed as
     * parameter, from the repository
     * @param id
     * @throws Exception 
     */
    public void removePokemon(int id) throws Exception;
    
    /**
     * Update a property in the repository
     * @param pokemon
     * @throws Exception 
     */
    public void editPokemon(Pokemon pokemon) throws Exception;
    
//    /**
//     * Search for a pokemon by its pokemon name
//     * @param name
//     * @return
//     * @throws Exception 
//     */
//    public List<Pokemon> searchPokemonByName(String name) throws Exception;
    /**
     * Return all the user in the repository
     * @return
     * @throws Exception 
     */
    public List<User> getAllUser() throws Exception;
}
