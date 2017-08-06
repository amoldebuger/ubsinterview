package com.ubs.opsit.interviews;

import org.apache.commons.lang.StringUtils;

import com.ubs.opsit.interviews.enums.LAMP;

public class BerlinClockTimeCalculator {

	@SuppressWarnings("deprecation")
	public String getTime(String time) throws Exception {

		String timeArr[] = time.split("\\:");
		int hr = Integer.parseInt(timeArr[0]);
		int min = Integer.parseInt(timeArr[1]);
		int sec = Integer.parseInt(timeArr[2]);

		if (isTimeValid(hr, min, sec)) {

			StringBuilder builder = new StringBuilder(32);
			builder.append(getSeconds(sec)).append("\r\n")
					.append(getHour_1(hr)).append("\r\n").append(getHour_2(hr))
					.append("\r\n").append(getMin_1(min)).append("\r\n")
					.append(getMin_2(min)).trimToSize();

			return builder.toString();
		}

		return "";

	}

	public String getSeconds(int sec) {
		if (sec % 2 == 0) {
			return LAMP.YELLOW_LAMP.getColor();
		}

		else {
			return LAMP.OFF_LAMP.getColor();
		}
	}

	public String getMin_1(int min) {
		int yellowLamps = min / 5;
		int i = 2;
		char yellowcolor = LAMP.YELLOW_LAMP.getColor().charAt(0);
		char redcolor = LAMP.RED_LAMP.getColor().charAt(0);
		String lampRow = getLampRow(yellowLamps, 11, LAMP.YELLOW_LAMP);
		char[] charArray = lampRow.toCharArray();
		while (i < yellowLamps) {
			if (charArray[i] == yellowcolor) {
				charArray[i] = redcolor;    // Switching color to red if its yellow
			}
			i = i + 3;  //  Looking for positon  5,8 hence adding 3
		}
		return new String(charArray);
	}

	public String getMin_2(int min) {
		int yellowLamps = min % 5;
		return getLampRow(yellowLamps, 4, LAMP.YELLOW_LAMP);
	}

	public String getHour_1(int hr) {
		int redLamps = hr / 5;
		return getLampRow(redLamps, 4, LAMP.RED_LAMP);
	}

	public String getHour_2(int hr) {
		int redLamp = hr % 5;
		return getLampRow(redLamp, 4, LAMP.RED_LAMP);
	}

	// Fill row with given color for repeat times  & then fill with O for left positions.
	public String getLampRow(int repeat, int size, LAMP lamp) {

		return StringUtils.repeat(lamp.getColor(), repeat).concat(
				StringUtils.repeat(LAMP.OFF_LAMP.getColor(), size - repeat));
	}

	public boolean isTimeValid(int hr, int min, int sec) {

		if (hr < 0 || hr > 24 || min < 0 || min > 60 || sec < 0 || sec > 60) {
			return false;
		}

		return true;

	}

}
