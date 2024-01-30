package demo.service;

import demo.Entity.Department;
import demo.error.DepartmentNotFoundException;
import demo.reposetory.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        //.get return Optional object so you can handle Exception
        // return this.departmentRepository.findById(departmentId).get();

        //becuase it actually returns optional we can omit get(); and declare it in Optional object
        Optional<Department> department =  this.departmentRepository.findById(departmentId);

        //so we want to hande exception ,so we can check this Optional object is empty or not
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department not available");//write the message with entire unuseful error
        }else {
            return department.get();
        }

    }

    @Override
    public void deleteDepartmentId(Long departmentId) {
        this.departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        /**
         * if you want to update just pass the URL with the path that you declare
         * in @RestController methods like :http://localhost:8080/departments/4 (4 is {id})
         *
         * you can just write the only part that you want to edit in json body
         * BE CAREFUL URL THAT YOU NEED TO PAST IN PUT PART
         */

        Department depDb = departmentRepository.findById(departmentId).get();//retuning Department as well ,no need to new
        //new statement
        if (Objects.nonNull(department.getDepartmentId2()) &&
                department.getDepartmentId2() != 0){
            depDb.setDepartmentName(department.getDepartmentName());
        }


        if (Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName())){
            depDb.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentCode()) &&
        !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDb.setDepartmentCode(department.getDepartmentCode());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) &&
        !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDb.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDb);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        //for finding data by name there is no default method ,so we declare method by key name in spring

        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);

        //this method has not body, but I think spring will fid it as spatial method
        /**the formula of the naming method to have that as spatial spring method is (in JpaRepository implement or subclasses):
         * findBy + (name of field of Department or database object in this class is Department) in camel case
         * example:
         * findByDepartmentName
         */

    }
    //I set Imp at the end of the name so to understand that this is implemented
}
