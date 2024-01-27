package demo.service;

import demo.Entity.Department;
import demo.reposetory.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//so we can know it has service implementation
//This annotation is a general-purpose stereotype
//i think if you have to do some services on database use this on the method
public class DepartmentServiceImp implements DepartmentService{
    @Autowired //without new statement we make it to attach particular reference
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        //save(); you should pass @Entity objects as its parameter
        return this.departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();//
    }
    //I set Imp at the end of the name so to understand that this is implemented
}
