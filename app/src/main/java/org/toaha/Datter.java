package org.toaha;

/*
A greatest library for problem 2k38 for your 32bit processor.It is also a helper Java class.
Learn more about here: https://en.m.wikipedia.org/wiki/Year_2038_problem

@If you use my library in your project or anywhere, please give me credit only.

@Author: Hasin Israk Toaha (SSC 2025)(Constant T)
Facebook: facebook.com/constant.t.10/
Mail: toaha.banaripara@gmail.com

@   Written in JavaNIDE ,in 12:17AM, 04/12/2024
@Happy Coding!

*/
import java.util.*;
import java.lang.*;
import java.util.regex.*;
import org.toaha.UnixTimer;

public class Datter extends UnixTimer {



    @Override
    public String calculateUnixTime(String date) {
       
        return super.calculateUnixTime(date);
    }

	public static String updateDateTime(String date) {
		String regex = "(\\d{2}:\\d{2}:(\\d{2})\\s*(AM|PM))\\s*-\\s*(\\d{2})/(\\d{2})/(\\d{4})";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(date);

		if (matcher.find()) {
			String time = matcher.group(1);
			int seconds = Integer.parseInt(matcher.group(2));
			String period = matcher.group(3);
			int day = Integer.parseInt(matcher.group(4));
			int month = Integer.parseInt(matcher.group(5));
			int year = Integer.parseInt(matcher.group(6));

			seconds += 1;

			if (seconds == 60) {
				seconds = 0;
				int minutes = Integer.parseInt(time.split(":")[1]) + 1;

				if (minutes == 60) {
					minutes = 0;
					int hours = Integer.parseInt(time.split(":")[0]);
					hours += 1;

					if (hours == 12) {
						period = period.equals("AM") ? "PM" : "AM";
					}
					if (hours == 13) {
						hours = 1;
					}
					time = String.format("%02d:%02d:%02d%s", hours, minutes, seconds, period);
				} else {
					time = String.format("%s:%02d:%02d%s", time.split(":")[0], minutes, seconds, period);
				}
			} else {
				time = String.format("%s:%02d:%02d%s", time.split(":")[0], Integer.parseInt(time.split(":")[1]),
						seconds, period);
			}

			if (seconds == 0) {
				day += 1;

				int daysInMonth = getDaysInMonth(month, year);
				if (day > daysInMonth) {
					day = 1;
					month += 1;

					if (month > 12) {
						month = 1;
						year += 1;
					}
				}
			}

			StringJoiner joiner = new StringJoiner(" - ");
			joiner.add(time);
			joiner.add(String.format("%02d/%02d/%04d", day, month, year));

			return joiner.toString();
		} else {
			return "Invalid date format";
		}
	}

	

	private static int getDaysInMonth(int month, int year)
	{
		HashMap<Integer, Integer> daysInMonths = new HashMap<>();
		daysInMonths.put(1, 31);
		daysInMonths.put(2, 28);
		daysInMonths.put(3, 31);
		daysInMonths.put(4, 30);
		daysInMonths.put(5, 31);
		daysInMonths.put(6, 30);
		daysInMonths.put(7, 31);
		daysInMonths.put(8, 31);
		daysInMonths.put(9, 30);
		daysInMonths.put(10, 31);
		daysInMonths.put(11, 30);
		daysInMonths.put(12, 31);
		
		if (month < 1 || month > 12)
		{
			return 0;
		}
		
		int days = daysInMonths.get(month);
		
		if (month == 2)
		{
			if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
			{
				days = 29;
			}
		}
		
		return days;
	}
}