package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.Repository.StudentRepository;
import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student studentRequest) {
        Student student = new Student();
        if (studentRepository.findAll().isEmpty()) {
            student.setId(1);
        } else {
            // GTB: 计算ID的逻辑略复杂，可以用字段来保存最大ID
            student.setId(studentRepository.getMaxStudentId() + 1);
        }
        student.setName(studentRequest.getName());
        studentRepository.save(student);
        return student;
    }

}
