package demo.controller;

import demo.Entity.Department;
import demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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


}
