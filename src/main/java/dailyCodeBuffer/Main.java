package dailyCodeBuffer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication// declare this to make class the spring
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);//it let you to hava server embedded
    }


    @GetMapping("/")//don't forget to have @RestController for activating this method

    public String greet(){
        System.out.println("\ngreet call");
        return "ddddddd";
    }
}
