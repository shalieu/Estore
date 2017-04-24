/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estore.admin.backingbean;

import com.estore.model.Movie;
import com.estore.service.MovieService;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author A.M.S.Madhuwanthi
 */
@Named(value = "movieAddBacking")
@ViewScoped
public class MovieAddBacking {

   @EJB
   MovieService movieService;
   
   @Named
    @Produces
    @RequestScoped
   
   Movie movie = new Movie ();

    public MovieService getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    
    public String createMovie()
    {
        movieService.addNewMovie(movie);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(movie.getName()+" Saved Successfully"));
      clear ();
        return null;
       
        
    }
    public void clear()
    {
        movie.setName("");
    }
    
}
