package org.example.condigbat.payload.enums;

import lombok.*;
import org.example.condigbat.entity.enums.RoleEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO implements Serializable {

    private Integer id;


    private String email;

    private String password;

    @Enumerated(value = EnumType.STRING)
    private RoleEnum roleEnum;

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
        this.roleEnum = RoleEnum.ROLE_USER;
    }

    public UserDTO(Integer id) {
        this.id = id;
    }
}
