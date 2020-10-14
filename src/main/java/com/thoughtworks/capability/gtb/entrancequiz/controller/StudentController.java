package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Group;
import com.thoughtworks.capability.gtb.entrancequiz.dto.GroupResponse;
import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentResponse;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
// GTB: 推荐使用@RestController，这样就可以省略@ResponseBody
public class StudentController {

    // GTB: 推荐使用构造函数注入
    // GTB: 违反封装性，字段应该使用private修饰
    @Autowired
    StudentService studentService;

    // GTB: 可以使用类级别的@RequestMapping抽取公共的路径前缀
    // GTB: 违反Restful实践，请求成功后直接返回数据即可，不需要用StudentResponse再包一层
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.created(URI.create("/students")).body(studentService.createStudent(student));
    }

    @GetMapping("/students/group")
    // GTB: 应该创建专门的对象来表示小组
    public ResponseEntity<List<Group>> getGroupStudents() {
        return ResponseEntity.ok(studentService.getGroupingStudents());
    }

    @PostMapping("/students/group")
    public ResponseEntity<List<Group>>  groupStudents() {
        return ResponseEntity.ok(studentService.groupingStudents());
    }
}
