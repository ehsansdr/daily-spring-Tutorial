package demo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

//@Component//if you want to have this class as component have this annotation
//be careful if you want to scan this by special class add @ComponentScan to that class

@RestController
public class helloController {


}
