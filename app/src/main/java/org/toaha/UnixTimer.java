package org.toaha;


/* 
 A greatest library for problem 2k38 for your 32bit processor.It is helper Java class.
 Learn more about here: https://en.m.wikipedia.org/wiki/Year_2038_problem

@If you use my library in your project or anywhere, please give me credit only.

@Author: Hasin Israk Toaha (SSC 2025)(Constant T)
    Facebook: facebook.com/constant.t.10/   
    Mail: toaha.banaripara@gmail.com
    
@   Written in JavaNIDE ,in 12:17AM, 04/12/2024
@Happy Coding!

*/
import java.util.regex.*;
import java.lang.*;
public class UnixTimer
{
    
    public  String calculateUnixTime(String date) 
    {
        Matcher matcher = Pattern.compile("(\\d{1,2}):(\\d{2}):(\\d{2})(AM|PM) - (\\d{2})/(\\d{2})/(\\d{4})").matcher(date);
        
        if (!matcher.matches()) 
        {
            throw new IllegalArgumentException("Invalid date format.");
        }
        
        String hourStr = matcher.group(1);
        String minuteStr = matcher.group(2);
        String secondStr = matcher.group(3);
        String period = matcher.group(4);
        String dayStr = matcher.group(5);
        String monthStr = matcher.group(6);
        String yearStr = matcher.group(7);
        
        int hour = Integer.parseInt(hourStr);
        if (period.equals("PM") && hour < 12) 
        {
            hour += 12;
        } 
        else if (period.equals("AM") && hour == 12) 
        {
            hour = 0;
        }

        long totalSeconds = calculateTotalSeconds(hour, minuteStr, secondStr, dayStr, monthStr, yearStr);
        return Long.toString(totalSeconds);
    }

    private static long calculateTotalSeconds(int hour, String minuteStr, String secondStr, String dayStr, String monthStr, String yearStr) 
    {
        int minute = Integer.parseInt(minuteStr);
        int second = Integer.parseInt(secondStr);
        int day = Integer.parseInt(dayStr);
        int month = Integer.parseInt(monthStr) - 1;
        int year = Integer.parseInt(yearStr);

        long totalDays = calculateTotalDays(year, month, day);
        long totalSeconds = totalDays * 86400;
        totalSeconds += hour * 3600;
        totalSeconds += minute * 60;
        totalSeconds += second;

        return totalSeconds;
    }

    private static long calculateTotalDays(int year, int month, int day) 
    {
        long totalDays = 0;
        for (int y = 1970; y < year; y++) 
        {
            totalDays += isLeapYear(y) ? 366 : 365;
        }
        for (int m = 0; m < month; m++) 
        {
            totalDays += daysInMonth(m, year);
        }
        totalDays += day - 1;

        return totalDays;
    }

    private static boolean isLeapYear(int year) 
    {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static int daysInMonth(int month, int year) 
    {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return (month == 1 && isLeapYear(year)) ? 29 : daysInMonths[month];
    }
}