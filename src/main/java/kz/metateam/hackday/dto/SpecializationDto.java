package kz.metateam.hackday.dto;

import lombok.Data;

@Data
public class SpecializationDto {
    private String name;
    private String description;
    private String lessonA;
    private String code;
    private String lessonB;
    private int minMark;
}
