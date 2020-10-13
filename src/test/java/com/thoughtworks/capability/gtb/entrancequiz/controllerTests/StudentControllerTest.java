package com.thoughtworks.capability.gtb.entrancequiz.controllerTests;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentService studentService;

    private Student student;

    @BeforeEach
    void setUp() {
        StudentService.deleteAllStudents();
        student = Student.builder()
                .studentName("杨乾")
                .build();
    }

    @Test
    void should_return_all_students_when_get_all_students_success() throws Exception {
        StudentService.addStudent(student);
        mockMvc.perform(get("/students"))
                .andExpect(jsonPath("$.data", hasSize(1)))
                .andExpect(jsonPath("$.data[0].studentName", is("杨乾")))
                .andExpect(status().isOk());
    }

    @Test
    void should_return_student_info_when_create_student_success() throws Exception {
        studentService.createStudent(student);
        mockMvc.perform(get("/students"))
                .andExpect(jsonPath("$.data", hasSize(1)))
                .andExpect(jsonPath("$.data[0].studentName", is("杨乾")))
                .andExpect(status().isOk());
    }

}
