package kz.metateam.hackday.dto;

import lombok.Data;

@Data
public class RegistrationDto {
    private String email;
    private String password;
    private String firstName;
    private String secondName;
}
