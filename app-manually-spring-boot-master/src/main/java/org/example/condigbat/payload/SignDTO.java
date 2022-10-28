package org.example.condigbat.payload;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@ToString
public class SignDTO {

    @NotBlank(message = "{MUST_NOT_BE_BLANK_EMAIL}")
    @Email
    private String email;

    @NotBlank(message = "{MUST_NOT_BE_BLANK_PASSWORD}")
    private String password;
}
