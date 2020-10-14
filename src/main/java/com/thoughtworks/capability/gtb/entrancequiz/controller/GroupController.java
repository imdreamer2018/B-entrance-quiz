package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Group;
import com.thoughtworks.capability.gtb.entrancequiz.service.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("groups")
    // GTB: 应该创建专门的对象来表示小组
    public ResponseEntity<List<Group>> getGroupStudents() {
        return ResponseEntity.ok(groupService.getGroupingStudents());
    }

    @PostMapping("groups")
    public ResponseEntity<List<Group>>  groupStudents() {
        return ResponseEntity.ok(groupService.groupingStudents());
    }
}
