package demo;
//if you press ctrl + alt + O : it removes all unused imports

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Component//if you want to have this class as component have this annotation
//be careful if you want to scan this by special class add @ComponentScan to that class

@RestController//if you open this you see @ResponseBody it means always returns response body
//it has @Component so have @ComponentScan in the spring calls that you declare by @SpringBootApplication
//without @ComponentScan spring can not and would not find this component class
public class helloController {
    @GetMapping("/")//don't forget to have @RestController for activating this method
    public String greet(){
        System.out.println("\ngreet cal");//if someone refresh the tab this statement would execute again
        return "helloController in helloController without execution ";
    }


}
