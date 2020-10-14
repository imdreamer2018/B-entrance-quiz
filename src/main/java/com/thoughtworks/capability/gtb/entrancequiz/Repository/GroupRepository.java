package com.thoughtworks.capability.gtb.entrancequiz.Repository;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Group;
import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class GroupRepository {

    private final StudentRepository studentRepository;

    public GroupRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private static List<Group> groups = new ArrayList<>();


    public List<Group> findAll() {
        return groups;
    }

    public void grouping() {
        groups.clear();
        List<Student> shuffleStudents = new ArrayList<>(studentRepository.findAll());
        Collections.shuffle(shuffleStudents);
        int groupIndex = 0;
        int groupNum = 6;
        for (Student student: shuffleStudents) {
            List<Student> students = new ArrayList<>();
            Group group = new Group(groupIndex, students);
            // GTB: Magic Number
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
