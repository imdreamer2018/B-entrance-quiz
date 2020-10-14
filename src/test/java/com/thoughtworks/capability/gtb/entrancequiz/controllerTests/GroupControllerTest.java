package com.thoughtworks.capability.gtb.entrancequiz.controllerTests;

import com.thoughtworks.capability.gtb.entrancequiz.Repository.GroupRepository;
import com.thoughtworks.capability.gtb.entrancequiz.dto.Group;
import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GroupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GroupRepository groupRepository;

    private Student student;
    private Group group;

    @BeforeEach
    void setUp() {
        groupRepository.deleteAll();
        student = Student.builder()
                .name("李元芳")
                .build();
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        group = Group.builder()
                .name("1组")
                .studentList(studentList)
                .build();
    }

    @Test
    void should_return_groups_when_get_groups_success() throws Exception {
        groupRepository.save(group);
        mockMvc.perform(get("/groups"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].studentList[0].name", is("李元芳")))
                .andExpect(status().isOk());
    }
}
