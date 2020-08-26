/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042_assignment.repository.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author shaohangyu
 */
@Entity
@Table(name = "comment")
@NamedQueries({
    @NamedQuery(name = Comment.GET_ALL_QUERY_NAME, query = "SELECT c FROM Comment c")})
public class Comment implements Serializable{
    
    public static final String GET_ALL_QUERY_NAME = "Comment.getAll";
    
    public int commentId;
    public String com;
    public Pokemon pokemon;

    public Comment(int commentId, String com, Pokemon pokemon) {
        this.commentId = commentId;
        this.com = com;
        this.pokemon = pokemon;
    }

    public Comment() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }
    
    @ManyToOne
    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.commentId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comment other = (Comment) obj;
        if (this.commentId != other.commentId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comment{" + "commentId=" + commentId + ", com=" + com + '}';
    }
    
    
}
