package com.thoughtworks.capability.gtb.entrancequiz.Repository;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentRepository {

    private static int maxStudentId = 1;

    private static List<Student> studentList = initStudentList();

    private static List<Student> initStudentList() {
        List<Student> studentList = new ArrayList<>();
        // GTB: 可以使用Java8 Stream API简化
        String[] students = {
                "成吉思汗", "鲁班七号", "太乙真人",
                "钟无艳", "花木兰", "雅典娜",
                "芈月", "白起", "刘禅",
                "庄周", "马超", "刘备",
                "哪吒", "大乔", "蔡文姬"
        };
        for (int i = 0; i < students.length; i++) {
            maxStudentId++;
            studentList.add(new Student(i + 1, students[i]));
        }
        return studentList;
    }

    public void deleteAll() {
        studentList.clear();
    }

    public void save(Student student) {
        maxStudentId++;
        studentList.add(student);
    }

    public List<Student> findAll() {
        return studentList;
    }

    public int getMaxStudentId () {
        return maxStudentId;
    }
}
