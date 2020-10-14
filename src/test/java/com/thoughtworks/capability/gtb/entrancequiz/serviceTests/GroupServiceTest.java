package com.thoughtworks.capability.gtb.entrancequiz.serviceTests;

import com.thoughtworks.capability.gtb.entrancequiz.Repository.GroupRepository;
import com.thoughtworks.capability.gtb.entrancequiz.dto.Group;
import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.GroupService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@SpringBootTest
public class GroupServiceTest {

    private GroupService groupService;

    @Mock
    GroupRepository groupRepository;

    @BeforeEach
    void setup() {
        initMocks(this);
        groupService = new GroupService(groupRepository);
    }

    @Test
    void should_return_groups_when_get_groups_success() {
        Student student = Student.builder()
                .name("李元芳")
                .build();
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        Group group = Group.builder()
                .studentList(studentList)
                .build();
        List<Group> groups = new ArrayList<>();
        groups.add(group);
        when(groupRepository.findAll()).thenReturn(groups);
        List<Group> groupStudents = groupService.getGroupingStudents();
        System.out.println(groupStudents);
        assertEquals("李元芳", groupStudents.get(0).getStudentList().get(0).getName());
    }

    @Test
    void should_return_groups_when_grouping_success() {
        Student student = Student.builder()
                .name("李元芳")
                .build();
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        Group group = Group.builder()
                .studentList(studentList)
                .build();
        List<Group> groups = new ArrayList<>();
        groups.add(group);
        when(groupRepository.findAll()).thenReturn(groups);
        List<Group> groupStudents = groupService.groupingStudents();
        assertEquals("李元芳", groupStudents.get(0).getStudentList().get(0).getName());
    }
}
