package demo.reposetory;

import demo.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    //for repository or saving data we need @Repository class or object of classes  that implement
    //this interface

    //instead of creating simple methods extends  JpaRepositorya nd use its methods (ctrl and click on that)
    //like findAll() 2:13:30
}
