/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restController;

import domain.Actor;
import domain.Facade;
import domain.Movie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cathlene
 */
@CrossOrigin
@RestController
@RequestMapping("/movie")
public class MovieRestController {
       @Autowired
    private Facade facade;
     
        @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addMovie(@RequestBody Movie movie){
        facade.addMovie(movie);
    }
     @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getMovies(){
        List<Movie> movies=facade.getMovies();
        return facade.getMovies();
    } 
    
     @RequestMapping(value = "/duration",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getMovieWithDurationLessOrEqual(@RequestParam ("Duur") Integer duur){
        return  facade.getMoviesWithSpecificDuration(duur);
    }
    
     
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void removeMovie(@PathVariable long id){
        facade.removeMovie(id);
    }
    
       @RequestMapping(value="/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie getMovie(@PathVariable long id){
        return facade.getMovie(id);
    }

     @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editMovie(@RequestBody Movie movie){
        facade.updateMovie(movie);
    }
}
