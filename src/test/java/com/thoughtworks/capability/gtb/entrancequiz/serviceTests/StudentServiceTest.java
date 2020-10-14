package com.thoughtworks.capability.gtb.entrancequiz.serviceTests;

import com.thoughtworks.capability.gtb.entrancequiz.Repository.StudentRepository;
import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@SpringBootTest
class StudentServiceTest {

    private StudentService studentService;

    @Mock
    StudentRepository studentRepository;

    @BeforeEach
    void setup() {
        initMocks(this);
        studentService = new StudentService(studentRepository);
    }


    @Test
    void should_return_all_students_info_when_get_students_success() {
        Student student = Student.builder()
                .name("李元芳")
                .build();
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        when(studentRepository.findAll()).thenReturn(studentList);
        List<Student> response = studentService.getAllStudents();
        assertEquals("李元芳", response.get(0).getName());
    }

    @Test
    void should_return_student_info_when_create_student_success() {
        Student student = Student.builder()
                .name("李元芳")
                .build();
        Student response = studentService.createStudent(student);
        assertEquals("李元芳", response.getName());
    }


}
