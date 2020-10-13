package com.thoughtworks.capability.gtb.entrancequiz.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse<T> {
    private Integer code;
    private String message;
    private T data;
}
