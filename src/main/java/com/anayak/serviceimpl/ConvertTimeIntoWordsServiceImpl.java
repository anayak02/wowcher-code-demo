package com.anayak.serviceimpl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.anayak.service.ConvertTimeIntoWordsService;

/**
 * 
 * @author arjun
 *
 */
@Service
public class ConvertTimeIntoWordsServiceImpl implements ConvertTimeIntoWordsService {

	@Override
	public String convert(String time) {

		String result = "";

		String nums[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
				"twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six",
				"twenty seven", "twenty eight", "twenty nine", "thirty", "thirty one", "thirty two", "thirty three",
				"thirty four", "thirty five", "thirty six", "thirty seven", "thirty eight", "thirty nine", "forty",
				"forty one", "forty two", "forty three", "forty four", "forty five", "forty six", "forty seven",
				"forty eight", "forty nine", "fifty", "fifty one", "fifty two", "fifty three", "fifty four",
				"fifty five", "fifty six", "fifty seven", "fifty eight", "fifty nine" };

		DateTimeFormatter dt = DateTimeFormatter.ofPattern("hh:mm a");

		String strTime[] = time.split(":");

		try {
			int h = Integer.parseInt(strTime[0]);
			int m = Integer.parseInt(strTime[1]);

			if (h == 12 && m == 0) {

				result = "It's Midday";

			} else if (h == 24 && m == 0) {

				result = "It's Midnight";

			} else if (h <= 23 && m <= 59) {

				LocalTime localtime = LocalTime.of(h, m);
				System.out.println(dt.format(localtime));

				String str[] = dt.format(localtime).split(":");

				int hr = Integer.parseInt(str[0]);

				String minStr[] = str[1].split(" ");

				int min = Integer.parseInt(minStr[0]);

				String amOrPm = minStr[1];

				result = "It's " + nums[hr] + " " + nums[min] + " " + amOrPm;

			} else {

				result = "Please provide valid time...";

			}

		} catch (Exception e) {

			result = "<h1 style='color:red'> Error occured : </h1>" + e.getMessage();

		}

		return result;
	}

}
