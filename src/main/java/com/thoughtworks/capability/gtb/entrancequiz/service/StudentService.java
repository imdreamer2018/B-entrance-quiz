package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    static List<Student> studentList = initStudentList();

    private static List<Student> initStudentList() {
        List<Student> studentList = new ArrayList<>();
        String[] students = {
                "成吉思汗", "鲁班七号", "太乙真人",
                "钟无艳", "花木兰", "雅典娜",
                "芈月", "白起", "刘禅",
                "庄周", "马超", "刘备",
                "哪吒", "大乔", "蔡文姬"
        };
        for (int i = 0; i < students.length; i++) {
            studentList.add(new Student(i + 1, students[i]));
        }
        return studentList;
    }

    public StudentResponse<List<Student>> getAllStudents() {
        StudentResponse<List<Student>> studentResponse = new StudentResponse<>();
        studentResponse.setCode(200);
        studentResponse.setMessage("get all students success!");
        studentResponse.setData(studentList);
        return studentResponse;
    }
}
