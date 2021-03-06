/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restController;

import domain.Actor;
import domain.Facade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
/**
 *
 * @author cathlene
 */

@CrossOrigin
@RestController
@RequestMapping("/actor")
public class ActorRestController {
    
      @Autowired
    private Facade facade;
      
       @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addActor(@RequestBody Actor actor){
        facade.addActor(actor);
    }
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Actor> getActors(){
        return facade.getActors();
    }
    
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void removeActor(@PathVariable long id){
        facade.removeActor(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editActor(@RequestBody Actor actor){
        facade.updateActor(actor);
    }
    
    
     @RequestMapping(value="/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Actor getActor(@PathVariable long id){
        return facade.getActor(id);
    }
    
    
    
    
    
}
