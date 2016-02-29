package com.epam.example.junittask9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParser {
	public double execute(String expression) {
		Pattern p = Pattern.compile("(\\d+(?:\\.\\d+)?)\\s*([\\+\\-\\*\\/])\\s*(\\d+(?:\\.\\d+)?)");
		Matcher m = p.matcher(expression);
		if (m.matches()) {
			double firstNumber = Double.parseDouble(m.group(1));
			String action = m.group(2);
			double secondNumber = Double.parseDouble(m.group(3));
			switch (action.charAt(0)) {
				case '+': 
					return firstNumber + secondNumber; 
				case '-': 
					return firstNumber - secondNumber; 
				case '*': 
					return firstNumber * secondNumber; 
				case '/': 
					if (secondNumber == 0.0)
						throw new IllegalArgumentException("Division by zero!");
					return firstNumber / secondNumber; 
				default: throw new IllegalArgumentException("Unable to parse operator!");
			}
		} else {
			throw new IllegalArgumentException("Wrong input!");
		}
		
	}
}
