package com.thoughtworks.capability.gtb.entrancequiz.serviceTests;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Group;
import com.thoughtworks.capability.gtb.entrancequiz.dto.GroupResponse;
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

    @Test
    void should_return_student_info_when_create_student_success() {
        Student student = Student.builder()
                .name("yangqian")
                .build();
        StudentResponse<Student> response = studentService.createStudent(student);
        assertEquals("create student success!", response.getMessage());
    }

    @Test
    void should_return_grouping_students_when_get_group_student_success() {
        GroupResponse<List<Group>> response = studentService.getGroupingStudents();
        assertEquals("get grouping students success!", response.getMessage());
    }

}
