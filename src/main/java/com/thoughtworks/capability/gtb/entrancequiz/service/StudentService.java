package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.Repository.GroupRepository;
import com.thoughtworks.capability.gtb.entrancequiz.Repository.StudentRepository;
import com.thoughtworks.capability.gtb.entrancequiz.dto.Group;
import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final GroupRepository groupRepository;

    public StudentService(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student studentRequest) {
        Student student = new Student();
        if (studentRepository.findAll().isEmpty()) {
            student.setStudentId(1);
        } else {
            // GTB: 计算ID的逻辑略复杂，可以用字段来保存最大ID
            student.setStudentId(studentRepository.getMaxStudentId() + 1);
        }
        student.setStudentName(studentRequest.getStudentName());
        studentRepository.save(student);
        return student;
    }

    public List<Group> getGroupingStudents() {
        return groupRepository.findAll();
    }

    public List<Group> groupingStudents() {
        groupRepository.grouping();
        return groupRepository.findAll();
    }

}
