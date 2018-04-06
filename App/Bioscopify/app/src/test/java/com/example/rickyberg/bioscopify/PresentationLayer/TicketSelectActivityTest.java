package com.example.rickyberg.bioscopify.PresentationLayer;

import com.example.rickyberg.bioscopify.ApplicationLayer.RandomMovieDate;

import org.junit.Test;

import java.util.Calendar;
import java.util.Locale;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ricky on 04/04/2018.
 */
public class TicketSelectActivityTest {
    @Test
    public void getList() throws Exception {
        RandomMovieDate date = new RandomMovieDate();
        Calendar c = Calendar.getInstance(Locale.FRANCE);
        String time = date.getTime(c);
        int hour = Integer.parseInt(time.split(":")[0]) + 1;
        time.replace(time.split(":")[0], "" + hour);
        assertTrue("Correct", date.hasTimePassed(c, time));
        assertFalse("false", !date.hasTimePassed(c, time));
    }

}