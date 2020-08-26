/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042_assignment.repository.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author shaohangyu
 */
@Entity
@Table(name = "Pokemon")
@NamedQueries({
    @NamedQuery(name = Pokemon.GET_ALL_QUERY_NAME, query = "SELECT p FROM Pokemon p ORDER BY p.pokemonId DESC")})
public class Pokemon implements Serializable{
    
    public static final String GET_ALL_QUERY_NAME = "Pokemon.getAll";
    
    public int pokemonId;
    public String name;
    public int likes;// number of likes by users
    public User user;
    public Set<Comment> comments;
    
    public Pokemon() {
    }

    public Pokemon(int pokemonId, String name, int likes, User user) {
        this.pokemonId = pokemonId;
        this.name = name;
        this.likes = likes;
        this.user = user;
        this.comments = new HashSet<>();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pokemon_id")
    public int getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    } 
    
    @OneToMany(mappedBy = "pokemon")
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.pokemonId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pokemon other = (Pokemon) obj;
        if (this.pokemonId != other.pokemonId) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return this.pokemonId + " - " + this.name + " - " + this.likes;
    }
}
