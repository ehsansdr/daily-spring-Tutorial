package demo.service;

import demo.Entity.Department;
import demo.reposetory.DepartmentRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
//i press alt + insert and the frame opened and i press setup/before and then the test class created

@SpringBootTest //so spring will know that this is particular test class
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @MockBean //
    private DepartmentRepository departmentRepository;

    @BeforeEach //this method for each and every test case added to the particular class (@Test method  i think)
    //@BeforeAll
    //@Before()
    void setUp() {

        Department department = Department.builder().//be careful about this
                departmentId2(1).departmentName("a")
                .departmentAddress("a")
                .departmentAddress("a")
                .departmentId(1)
                .build();//have this method at the end of building

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("a"))
                .thenReturn(department);
    }


    /* we want to have test the public Department fetchDepartmentByName(String departmentName);
    so we create the test method
    always name your method in test class so unique ,so you can realize the function of that
    create the autowired object in field ,it helps you in the method
    the object of the class that you test that by this class : DepartmentService
    */
    @Test //so this method will use as the test function

    //you change the name of displayed method on the test console
    //that will tick r false by displaying that name you put in ()
    //it helps you to have test method readable :
    @DisplayName("Get Data based on valid Department Name")
    @Disabled // when hole application running this annotation will skip (but I think not here)
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "a";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName,found.getDepartmentName());

    }
}