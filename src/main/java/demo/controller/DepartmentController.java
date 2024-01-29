package demo.controller;

import demo.Entity.Department;
import demo.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//so you can create rest API
public class DepartmentController {
    @Autowired//this attaches to the particular reference
    private DepartmentService departmentService;

    @PostMapping("/departments")//the name of entity that we use to see in db table
    //not declare here
    public Department saveDepartment(@Valid @RequestBody Department department){
        //@valid is annotation check and be careful about annotation that we use in
        //Department like @NotBlank
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