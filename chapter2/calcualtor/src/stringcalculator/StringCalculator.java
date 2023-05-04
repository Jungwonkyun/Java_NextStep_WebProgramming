package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public int add(String text) {
		if (isBlank(text)) {
			return 0;
		}

		String[] values = split(text);
		return sum(values);
	}
	
	private int sum(String[] values) {
		int sum = 0;
		for(String value: values) {
			sum+=toPositive(value);
		}
		return sum; 
	}
	
	private String[] split(String text) {
		
		//패턴과 매칭되는 문자열을 넣는다
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		
		//매칭되는 구분자가 있다면 
		if(m.find()) {
			String customDelimeter = m.group(1);
			return m.group(2).split(customDelimeter);
		}
		
		return text.split(",|:");
	}
	
	private boolean isBlank(String text) {
		return text == null || text.isEmpty();

	}
	
	private int toPositive(String value) {
		
		int number = Integer.parseInt(value);
		
		if(number < 0 ) {
			throw new RuntimeException();
		}
		
		return number;
	}
}
