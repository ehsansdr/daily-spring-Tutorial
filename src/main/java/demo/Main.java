package demo;


import demo.Entity.Department;
import demo.service.DepartmentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication// declare this to make class the spring
@RestController//for using @GetMapping and ... you should have this
@ComponentScan
@RequestMapping("d/dd/ddd")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);//it let you to hava server embedded
    }
    @RequestMapping
    public String fff(){
        return "ffffff";
    }
}
