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

    public static void deleteAllStudents() {
        studentList.clear();
    }

    public static void addStudent(Student student) {
        studentList.add(student);
    }

    public StudentResponse<List<Student>> getAllStudents() {
        StudentResponse<List<Student>> studentResponse = new StudentResponse<>();
        studentResponse.setCode(200);
        studentResponse.setMessage("get all students success!");
        studentResponse.setData(studentList);
        return studentResponse;
    }

    public StudentResponse<Student> createStudent(Student studentRequest) {
        StudentResponse<Student> studentResponse = new StudentResponse<>();
        Student student = new Student();
        if (studentList.isEmpty()) {
            student.setStudentId(1);
        } else {
            student.setStudentId(studentList.get(studentList.size() - 1).getStudentId() + 1);
        }
        student.setStudentName(studentRequest.getStudentName());
        studentList.add(student);
        studentResponse.setCode(200);
        studentResponse.setMessage("create student success!");
        studentResponse.setData(student);
        return studentResponse;
    }
}
