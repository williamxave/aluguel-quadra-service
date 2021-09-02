package com.aluguelquadra.service.day.renthour;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class RentHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String day;
    private String hour;
    private UUID idOwner;

    public RentHour(String day, String hour,UUID idOwner) {
        this.day = day;
        this.hour = hour;
        this.idOwner = idOwner;
    }

    @Deprecated
    public RentHour() {
    }

    public UUID getIdOwner() {
        return idOwner;
    }

    public String getDay() {
        return day;
    }

    public String getHour() {
        return hour;
    }
}
