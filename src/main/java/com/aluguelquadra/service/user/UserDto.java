package com.aluguelquadra.service.user;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Component
public class UserDto {

    @NotBlank
    private String name;
    @NotBlank
    @Positive
    private String day;
    @NotBlank
    private String hour;

    public UserDto(@NotBlank String name, @NotBlank String day, @NotBlank String hour) {
        this.name = name;
        this.day = day;
        this.hour = hour;
    }

    @Deprecated
    public UserDto() {}

    public User toModel(){
        return new User(
                this.name,
                this.day,
                this.hour
        );
    }

    public String getName() {
        return name;
    }

    public String getDay() {
        return day;
    }

    public String getHour() {
        return hour;
    }
}
