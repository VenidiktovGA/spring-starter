package ru.venidiktov.dto;

import java.time.LocalDate;

public record UserInfo(
        String firstName,
        String lastName,
        LocalDate birthDate
        ) {}
