package demo.service;

import demo.Entity.Department;

import java.util.List;

public interface DepartmentService {
    //because fo servicing in bunch of classes same method maybe same name and parameter we use interface
    //to ordering theme
    public Department saveDepartment(Department department);


    public List<Department> fetchDepartmentList();
}
