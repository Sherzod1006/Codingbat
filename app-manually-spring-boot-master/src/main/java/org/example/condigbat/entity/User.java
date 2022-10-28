package org.example.condigbat.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.condigbat.entity.enums.RoleEnum;
import org.example.condigbat.entity.template.AbsIntegerEntity;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
public class User extends AbsIntegerEntity implements UserDetails {

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private RoleEnum role = RoleEnum.ROLE_USER;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        accountNonExpired = accountNonLocked = credentialsNonExpired = true;
                enabled = false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

}
