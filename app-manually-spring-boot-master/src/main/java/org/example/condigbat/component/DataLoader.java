package org.example.condigbat.component;

import lombok.RequiredArgsConstructor;
import org.example.condigbat.entity.User;
import org.example.condigbat.entity.enums.RoleEnum;
import org.example.condigbat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlMode;


    @Override
    public void run(String... args) throws Exception {
        if (Objects.equals(ddlMode, "create")) {
            User admin = new User(
                    "admin@codingbat.com",
                    passwordEncoder.encode("root123"));
            admin.setRole(RoleEnum.ROLE_ADMIN);
            admin.setEnabled(true);

            userRepository.save(admin);
        }
        System.out.println("Hello");
    }
}
