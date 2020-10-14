package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.Repository.StudentRepository;
import com.thoughtworks.capability.gtb.entrancequiz.dto.Group;
import com.thoughtworks.capability.gtb.entrancequiz.dto.GroupResponse;
import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StudentService {

    final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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

    public GroupResponse<List<Group>> getGroupingStudents() {
        GroupResponse<List<Group>> groupResponse = new GroupResponse<>();
        groupResponse.setCode(200);
        groupResponse.setMessage("get grouping students success!");
        groupResponse.setData(groups);
        return groupResponse;
    }

    public GroupResponse<List<Group>> groupingStudents() {
        groups.clear();
        GroupResponse<List<Group>> groupResponse = new GroupResponse<>();
        groupResponse.setCode(200);
        groupResponse.setMessage("get grouping students success!");

        grouping();
        groupResponse.setData(groups);
        return groupResponse;
    }

    private static void grouping() {
        List<Student> shuffleStudents = new ArrayList<>(studentList);
        Collections.shuffle(shuffleStudents);
        int groupIndex = 0;
        int groupNum = 6;
        for (Student student: shuffleStudents) {
            List<Student> students = new ArrayList<>();
            Group group = new Group(groupIndex, students);
            // GTB: Magic Number
            if (groups.size() < 6) {
            if (groups.size() < groupNum) {
                groups.add(group);
            }
            groups.get(groupIndex).setGroupId(groupIndex + 1);
            groups.get(groupIndex).getGroupList().add(student);
            groupIndex++;
            if (groupIndex == groupNum)
                groupIndex = 0;
        }
    }

}
