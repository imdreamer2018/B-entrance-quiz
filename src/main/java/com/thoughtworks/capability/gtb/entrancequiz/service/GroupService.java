package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.Repository.GroupRepository;
import com.thoughtworks.capability.gtb.entrancequiz.dto.Group;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> getGroupingStudents() {
        return groupRepository.findAll();
    }

    public List<Group> groupingStudents() {
        groupRepository.grouping();
        return groupRepository.findAll();
    }
}
