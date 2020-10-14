package com.thoughtworks.capability.gtb.entrancequiz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// GTB: Group中应该包含name字段
public class Group {

    private Integer Id;

    private String name;

    private List<Student> studentList;
}
