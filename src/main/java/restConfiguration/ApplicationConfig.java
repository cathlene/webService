/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restConfiguration;
import domain.Facade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 *
 * @author cathlene
 */
@Configuration
@ComponentScan("restController")
@EnableWebMvc  
class ApplicationConfig {
     @Bean(destroyMethod ="closeConnection")
     public Facade facade() {
         return new Facade("stub");
     }
}
