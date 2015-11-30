package com.epam.example.dryexample.core.impl;

import java.util.Calendar;

import com.epam.example.dryexample.core.SuperPrint;

public class SuperPrintImpl implements SuperPrint {
	private static final String MESSAGE = "Good ";

	@Override
	public String print() {
		return MESSAGE + dayTime() + "!";
	}

	@Override
	public String print(String message) {
		return MESSAGE + dayTime() + ", " + message + "!";
	}

	private String dayTime() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (hour < 6)
			return "night";
		else if (hour < 12)
			return "morning";
		else if (hour < 18)
			return "afternoon";
		else
			return "evening";
	}
}
