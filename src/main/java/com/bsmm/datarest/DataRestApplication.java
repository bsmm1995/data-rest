package com.bsmm.datarest;

import com.bsmm.datarest.domain.entity.UserEntity;
import com.bsmm.datarest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class DataRestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DataRestApplication.class, args);
    }

    private final UserRepository repository;

    @Override
    public void run(String... args) {
        repository.save(new UserEntity("Bladimir Minga", "1@gmail.com"));
        repository.save(new UserEntity("Stanislao Medina", "2@gmail.com"));
        repository.save(new UserEntity("Matias Minga", "3@gmail.com"));
        repository.save(new UserEntity("Paula Brito", "4@gmail.com"));
        repository.save(new UserEntity("Emerly Minga", "5@gmail.com"));
    }
}
