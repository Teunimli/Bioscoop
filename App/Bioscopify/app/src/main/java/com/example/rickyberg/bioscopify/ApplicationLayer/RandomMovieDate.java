package com.example.rickyberg.bioscopify.ApplicationLayer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

/**
 * Created by Ricky on 03/04/2018.
 */

public class RandomMovieDate {

    private Random random;
    private Calendar c;

    public RandomMovieDate(){
        random = new Random();
        c = Calendar.getInstance(Locale.FRANCE);
    }

    public String getTime(Calendar currentTime)
    {
        return currentTime.get(Calendar.HOUR_OF_DAY) + ":" + currentTime.get(Calendar.MINUTE);
    }

    public boolean hasTimePassed(Calendar currentTime, String time)
    {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        java.util.Date d1 = null;
        try {
            d1 = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        java.sql.Time ppstime = new java.sql.Time(d1.getTime());

        if (ppstime.getHours() <= currentTime.get(Calendar.HOUR_OF_DAY)){
            return true;
        }
        else
        {
            return false;
        }
    }
}
