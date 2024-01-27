package demo.controller;

import demo.Entity.Department;
import demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//so you can create rest API
public class DepartmentController {
    @Autowired//this attaches to the particular reference
    private DepartmentService departmentService;

    @PostMapping("/departments")//the name of entity that we use to see in db table
    //not declare here
    public Department saveDepartment(@RequestBody Department department){
        return this.departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return this.departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")//to find by id (that we declare that name) the server will use this
    //it is necessary to have @PathVariable("id")
    //because we have @PathVariable("id") before our parameter it is not regular departmentId
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.fetchDepartmentById(departmentId);

    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentId(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentId(departmentId);
        return "department id : " + departmentId + " deleted successfully";
    }

    @PutMapping("/departments/{id}")//if you want to update s.t be careful to add that id in http
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                   @RequestBody Department department){

        return departmentService.updateDepartment(departmentId,department);

    }

}