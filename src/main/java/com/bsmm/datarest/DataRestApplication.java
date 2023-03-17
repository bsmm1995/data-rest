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
        repository.save(new UserEntity("Bladimir", "bladimir@gmail.com"));
        repository.save(new UserEntity("Stanislao", "stanislao@gmail.com"));
        repository.save(new UserEntity("Matias", "matias@gmail.com"));
        repository.save(new UserEntity("Paula", "paula@gmail.com"));
        repository.save(new UserEntity("Emerly", "emerly@gmail.com"));
    }
}
