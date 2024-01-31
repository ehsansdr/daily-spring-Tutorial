package demo.controller;

import demo.Entity.Department;
import demo.error.DepartmentNotFoundException;
import demo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentAddress("ahmedabad")
                .departmentCode("IT-06")
                .departmentName("IT")
                .departmentId(1L)
                .departmentId2(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        //NOT OK BECAUSE OF H2 INSTEAD OF SQL DATA BASE

        Department inputDepartment = Department.builder()
                .departmentAddress("ahmedabad")
                .departmentCode("IT-06")
                .departmentName("IT")
                .departmentId(1L)
                .departmentId2(1L)
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        //press alt + enter on MockMvcRequestBuilders and MockMvcResultMatchers click (add un-demand ...) and have clean code
        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("\"departmentId\": 4,\n" +
                        "    \"departmentId2\": 4,\n" +
                        "    \"departmentName\": \"IT\",\n" +
                        "    \"departmentAddress\": \"ahmedabad\",\n" +
                        "    \"departmentCode\": \"IT-06\""))
                .andExpect(MockMvcResultMatchers.status().isOk());//press alt + enter and (add un-demand ...)

    }

    @Test
    void fetchDepartmentById() throws DepartmentNotFoundException,Exception {
        //NOT OK BECAUSE OF H2 INSTEAD OF SQL DATA BASE

        Mockito.when(departmentService.fetchDepartmentById(1L));

        mockMvc.perform(MockMvcRequestBuilders.get("/departments")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));
    }
}