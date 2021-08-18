package com.aluguelquadra.service.date;

import javax.persistence.*;

@Entity
public class Hours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private HoursDay hoursDay;

    public Hours(HoursDay hoursDay) {
        this.hoursDay = hoursDay;
    }

    public Hours(){
    }

    public HoursDay getHoursDay() {
        return hoursDay;
    }

    @Override
    public String toString() {
        return "Hours{" +
                "hoursDay=" + hoursDay +
                '}';
    }
}
