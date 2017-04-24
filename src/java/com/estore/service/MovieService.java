/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.service;

import com.estore.model.Movie;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author A.M.S.Madhuwanthi
 */
@Stateless
public class MovieService {

    
     @PersistenceContext(unitName = "EstorePU")
    EntityManager em;

    public Movie addNewMovie(Movie movie) {
        
         em.persist(movie); //em kiyana reference eken ena data save karana method ekak 
        return movie;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
