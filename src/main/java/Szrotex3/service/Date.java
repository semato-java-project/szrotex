package Szrotex3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

@Service
public class Date {

    @Autowired
    public Date() {

    }

    public java.util.Date convertLocalDateLocalTimeToUtilDate(LocalDate localDate, LocalTime localTime) {

        if (localDate == null || localTime == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();

        calendar.set(
            localDate.getYear(),
            localDate.getMonthValue() - 1,
            localDate.getDayOfMonth(),
            localTime.getHour(),
            localTime.getMinute(),
            0
        );

        return calendar.getTime();
    }


}
