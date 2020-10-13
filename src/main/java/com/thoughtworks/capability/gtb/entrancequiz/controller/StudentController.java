package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Group;
import com.thoughtworks.capability.gtb.entrancequiz.dto.GroupResponse;
import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentResponse;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URI;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    @ResponseBody
    public ResponseEntity<StudentResponse<List<Student>>> getAllStudents() {
        StudentResponse<List<Student>> studentsResponse = studentService.getAllStudents();
        return ResponseEntity.ok(studentsResponse);
    }

    @PostMapping("/students")
    @ResponseBody
    public ResponseEntity<StudentResponse<Student>> createStudent(@RequestBody Student student) {
        StudentResponse<Student> studentResponse = studentService.createStudent(student);
        return ResponseEntity.created(URI.create("/students")).body(studentResponse);
    }

    @GetMapping("/students/group")
    @ResponseBody
    public ResponseEntity<GroupResponse<List<Group>> > getGroupStudents() {
        GroupResponse<List<Group>> groupingStudents = studentService.getGroupingStudents();
        return ResponseEntity.ok(groupingStudents);
    }
}
