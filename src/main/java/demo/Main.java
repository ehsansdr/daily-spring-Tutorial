package demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication// declare this to make class the spring
@RestController//for using @GetMapping and ... you should have this
@ComponentScan
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);//it let you to hava server embedded
    }




}
