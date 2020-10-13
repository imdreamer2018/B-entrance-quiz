package com.thoughtworks.capability.gtb.entrancequiz.dto;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @NotNull
    private Integer studentId;

    @NotNull
    private String studentName;


}
