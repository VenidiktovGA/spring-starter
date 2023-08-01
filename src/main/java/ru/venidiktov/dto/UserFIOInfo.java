package ru.venidiktov.dto;

import org.springframework.beans.factory.annotation.Value;

public interface UserFIOInfo {
    String getFirstName();
    String getLastName();

    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();

//    default String getFullName() {
//        return getFirstName() + " " + getLastName();
//    }
}
