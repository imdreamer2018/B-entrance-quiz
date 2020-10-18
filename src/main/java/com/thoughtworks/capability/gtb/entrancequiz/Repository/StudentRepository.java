package com.thoughtworks.capability.gtb.entrancequiz.Repository;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentRepository {

    private static int maxStudentId = 1;

    private static List<Student> studentList = new ArrayList<>();

    public void deleteAll() {
        studentList.clear();
    }

    public void save(Student student) {
        studentList.add(student);
    }

    public void saveMaxStudentId(int studentId) {
        maxStudentId = studentId;
    }

    public List<Student> findAll() {
        return studentList;
    }

    public int getMaxStudentId () {
        return maxStudentId;
    }
}
