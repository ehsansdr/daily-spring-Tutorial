package demo.reposetory;

import demo.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    //for repository or saving data we need @Repository class or object of classes  that implement
    //this interface
    //instead of creating simple methods extends  JpaRepositorya nd use its methods (ctrl and click on that)
    //like findAll() 2:13:30

    /** for finding data by name there is no default method ,so we declare method by key name in spring*/

    //this method has not body, but I think spring will fid it as spatial method

    /**the formula of the naming method to have that as spatial spring method is (in JpaRepository implement or subclasses):
     * findBy + (name of field of Department or database object in this class is Department) in camel case
     * example:
     * findByDepartmentName
     */
    public Department findByDepartmentName(String departmentName);
    @Query
    public Department findByDepartmentNameIgnoreCase(String departmentName);

}
