package com.example.rickyberg.bioscopify.ApplicationLayer;

import android.util.Log;

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
        c = Calendar.getInstance();
    }

    public String getTimeString(int amountHours, int amountMinutes)
    {
        String dt = "";  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aaa");
        c.add(Calendar.HOUR, amountHours);  // number of days to add
        c.add(Calendar.MINUTE, amountMinutes);
        c.set(Calendar.MINUTE, 0);
        dt = sdf.format(c.getTime());  // dt is now the new date

        return dt;
    }

    public String getDateString(int amountDays)
    {
        String dt = "";  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d");
        c.add(Calendar.DATE, 1);  // number of days to add
        dt = sdf.format(c.getTime());  // dt is now the new date

        return dt;
    }

    public boolean hasTimePassed(String time)
    {
        Calendar cal = Calendar.getInstance(Locale.FRANCE);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        java.util.Date d1 = null;
        try {
            d1 = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        java.sql.Time ppstime = new java.sql.Time(d1.getTime());

        Log.i("====", "hours parsed: "+ ppstime.getHours() + " hours currently: " + cal.get(Calendar.HOUR_OF_DAY));
        if (ppstime.getHours() < cal.get(Calendar.HOUR_OF_DAY)){
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getRandomTime()
    {
        int x = random.nextInt(100);
        boolean isHalfHour = x % 2 == 0;
        int y = isHalfHour ? 30 : 0;
        if(x < 60)
        {
            return getTimeString(1, y);
        }
        else if(x < 80)
        {
            return getTimeString(2, y);
        }
        else if(x < 90)
        {
            return getTimeString(3, y);
        }
        else
        {
            return getTimeString(4, y);
        }
    }
}
