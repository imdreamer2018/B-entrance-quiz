package com.thoughtworks.capability.gtb.entrancequiz.Repository;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Group;
import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class GroupRepository {

    private final StudentRepository studentRepository;

    public GroupRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private List<Group> groups = new ArrayList<>();


    public List<Group> findAll() {
        return groups;
    }

    public void save(Group group) {
        groups.add(group);
    }

    public void grouping() {
        groups.clear();
        List<Student> shuffleStudents = new ArrayList<>(studentRepository.findAll());
        Collections.shuffle(shuffleStudents);
        int groupIndex = 0;
        int groupNum = 6;
        for (Student student: shuffleStudents) {
            List<Student> students = new ArrayList<>();
            Group group = new Group(groupIndex,groupIndex + "组" , students);
            // GTB: Magic Number
            if (groups.size() < groupNum) {
                groups.add(group);
            }
            groups.get(groupIndex).setId(groupIndex + 1);
            groups.get(groupIndex).setName(groupIndex + 1 + "组");
            groups.get(groupIndex).getStudentList().add(student);
            groupIndex++;
            if (groupIndex == groupNum)
                groupIndex = 0;
            }
        }

    public void deleteAll() {
        groups.clear();
    }
}
