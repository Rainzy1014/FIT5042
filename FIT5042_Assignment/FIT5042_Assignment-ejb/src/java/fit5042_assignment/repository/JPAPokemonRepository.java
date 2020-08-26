/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042_assignment.repository;

import fit5042_assignment.repository.entities.Pokemon;
import fit5042_assignment.repository.entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author shaohangyu
 */
@Stateless
public class JPAPokemonRepository implements PokemonRepository{
    
    private EntityManager entityManager;

    @Override
    public void addPokemon(Pokemon pokemon) throws Exception {
        List<Pokemon> pokemons = entityManager.createNamedQuery(Pokemon.GET_ALL_QUERY_NAME).getResultList();
        pokemon.setPokemonId(pokemons.get(0).getPokemonId() + 1);
        entityManager.persist(pokemon);
    }

    @Override
    public Pokemon searchPokemonById(int id) throws Exception {
        Pokemon pokemon = entityManager.find(Pokemon.class, id);
        return pokemon;
    }

    @Override
    public List<Pokemon> getAllPokemons() throws Exception {
        return entityManager.createNamedQuery(Pokemon.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public void removePokemon(int id) throws Exception {
        Pokemon pokemon = this.searchPokemonById(id);
        if (pokemon != null){
            entityManager.remove(pokemon);
        }
    }

    @Override
    public void editPokemon(Pokemon pokemon) throws Exception {
        try {
            entityManager.merge(pokemon);
        } catch (Exception e) {
        }
    }

//    @Override
//    public List<Pokemon> searchPokemonByName(String name) throws Exception {
////        List<Pokemon> pokemons = entityManager.find(Pokemon.class, name).getResultList();
////        return pokemons;
//        return ;
//    }

    public List<User> getAllUser() throws Exception {
        return entityManager.createNamedQuery(User.GET_ALL_QUERY_NAME).getResultList();
    }
    
}
