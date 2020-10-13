package com.thoughtworks.capability.gtb.entrancequiz.serviceTests;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentResponse;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    StudentService studentService;


    @Test
    void should_return_all_students_info_when_get_students_success() {
        StudentResponse<List<Student>> response = studentService.getAllStudents();
        assertEquals("get all students success!", response.getMessage());
    }

}
