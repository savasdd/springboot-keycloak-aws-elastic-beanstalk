package com.aws.sekreterya.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCustomDto {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String realm;
}
