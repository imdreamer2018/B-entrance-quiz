package com.thoughtworks.capability.gtb.entrancequiz.controllerTests;

import com.thoughtworks.capability.gtb.entrancequiz.Repository.StudentRepository;
import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentRepository studentRepository;

    private Student student;

    @BeforeEach
    void setUp() {
        studentRepository.deleteAll();
        student = Student.builder()
                .name("杨乾")
                .build();
    }

    @Test
    void should_return_all_students_when_get_all_students_success() throws Exception {
        studentRepository.save(student);
        mockMvc.perform(get("/students"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("杨乾")))
                .andExpect(status().isOk());
    }

    @Test
    void should_return_student_info_when_create_student_success() throws Exception {
        String jsonValue =
                "{\"name\":\"杨乾\"}";
        mockMvc.perform(post("/students")
                .content(jsonValue).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        List<Student> all = studentRepository.findAll();
        assertEquals(all.size(), 1);
        assertEquals(all.get(0).getName(), "杨乾");
    }

}
