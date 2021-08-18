package com.aluguelquadra.service.user;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Component
public class OwnerDto {

    @NotBlank
    private String name;
    @NotBlank
    @Positive
    private String day;
    @NotBlank
    private String hour;

    public OwnerDto(@NotBlank String name, @NotBlank String day, @NotBlank String hour) {
        this.name = name;
        this.day = day;
        this.hour = hour;
    }

    @Deprecated
    public OwnerDto() {}

    public Owner toModel(){
        return new Owner(
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
