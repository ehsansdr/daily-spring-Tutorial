package demo.reposetory;

import demo.Entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;


    @BeforeEach
    void setUp() {
        Department department = Department
                .builder()
                .departmentId(1L)
                .departmentId2(1L)
                .departmentName("a")
                .departmentCode("a")
                .departmentAddress("a")
                .build();

        entityManager.persist(department);

    }

    @Test
    public void whenFindById_ThenReturnDepartment(){
        Department department =departmentRepository.findById(1L).get();//1L because we should get as long so have L in end

        assertEquals(department.getDepartmentName(),"a");


    }



}