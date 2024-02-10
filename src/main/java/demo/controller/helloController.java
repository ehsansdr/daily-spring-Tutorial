package demo.controller;
//if you press ctrl + alt + O : it removes all unused imports

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

//@Component//if you want to have this class as component have this annotation
//be careful if you want to scan this by special class add @ComponentScan to that class

@RestController//if you open this you see @ResponseBody it means always returns response body
//it has @Component so have @ComponentScan in the spring calls that you declare by @SpringBootApplication
//without @ComponentScan spring can not and would not find this component class
public class helloController {


    //if you want to have particular properties from application.properties
    //use this annotation to inform spring to get that form its source by this annotation and formula
    @Value("${welcome.message}")//welcome.message declared at application.properties  and has data
    private String message;


    @GetMapping("/")//don't forget to have @RestController for activating this method
    public String greet(){
        System.out.println("\ngreet cal");//if someone refresh the tab this statement would execute again
        return message;
    }


    @DeleteMapping("/d/d/{id}")//don't forget to have @RestController for activating this method
    public void putMapping(@PathVariable("id") Integer id){
        System.out.println("\nputMapping cal id : "+ id);//if someone refresh the tab this statement would execute again
    }


}
