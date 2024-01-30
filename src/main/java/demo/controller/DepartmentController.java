package demo.controller;

import demo.Entity.Department;
import demo.error.DepartmentNotFoundException;
import demo.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//so you can create rest API
public class DepartmentController {
    @Autowired//this attaches to the particular reference
    private DepartmentService departmentService;

    //this is for post map and getting info in which you want to get info and esc
    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    /** Logger should be from org.slf4j and we have 2 Loggers one of them is class and another is Interface
     * we need interface */

    @PostMapping("/departments")//the name of entity that we use to see in db table
    //not declare here
    public Department saveDepartment(@Valid @RequestBody Department department){
        //if you have @PostMapping you will see this print line in console if however you ask from server
        logger.info("Inside saveDepartment of DepartmentController");//you see this in console if you execute this method in last line
        //@valid is annotation check and be careful about annotation that we use in
        //Department like @NotBlank
        System.out.println("the postMapping asked");//if you search the link in insomnia or web browser
        return this.departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        //if you have @GetMapping you will see this print line in console
        logger.info("Inside fetchDepartmentList of DepartmentController");//you see this in console if you execute this method in last line
        return this.departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")//to find by id (that we declare that name) the server will use this
    //it is necessary to have @PathVariable("id")
    //because we have @PathVariable("id") before our parameter it is not regular departmentId
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);

    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentId(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentId(departmentId);
        return "department id : " + departmentId + " deleted successfully";
    }

    @PutMapping("/departments/{id}")//if you want to update s.t be careful to add that id in http
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                   @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }


    //finding data by that field that we declare as name in Department
    //@PathVariable("name") is ecclesial
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return this.departmentService.fetchDepartmentByName(departmentName);
    }
}