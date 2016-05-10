/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restController;

import domain.Facade;
import domain.Movie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cathlene
 */
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
        return facade.getMovies();
    } 
    
     @RequestMapping(value = "/duration",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getMovieWithDurationLessOrEqual(@RequestParam ("Duur") Integer duur){
        return  facade.getMoviesWithSpecificDuration(duur);
    }
    
     
    @RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void removeMovie(@RequestBody Movie movie){
        facade.removeMovie(movie);
    }

     @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editMovie(@RequestBody Movie movie){
        facade.updateMovie(movie);
    }
}
