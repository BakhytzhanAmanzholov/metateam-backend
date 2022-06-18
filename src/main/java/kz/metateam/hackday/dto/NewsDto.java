package kz.metateam.hackday.dto;

import lombok.Data;

@Data
public class NewsDto {
    private String title;
    private String description;
    private boolean pinned;
    private String[] tags;
}
