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

/**
 *
 * @author cathlene
 */
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
    
    @RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void removeActor(@RequestBody Actor actor){
        facade.removeActor(actor);
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editActor(@RequestBody Actor actor){
        facade.updateActor(actor);
    }
    
    
     @RequestMapping(value="/id", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Actor getActor(@PathVariable long id){
        return facade.getActor(id);
    }
    
    
    
    
    
}
