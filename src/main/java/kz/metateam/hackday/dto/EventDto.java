package kz.metateam.hackday.dto;

import lombok.Data;

@Data
public class EventDto {
    private String name;
    private String city;
    private String[] categoriesName;
}
