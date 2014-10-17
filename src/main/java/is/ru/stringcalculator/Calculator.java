package is.ru.stringcalculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else if(text.contains("/")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		if(numbers.startsWith("//"))
		{
			return splitCustomDelimiter(numbers);
		}
		else
		{
			String[] replaced = numbers.split(",|\n");
	    	return replaced;
		}
	}

	private static String[] splitCustomDelimiter(String text){

		Matcher match = Pattern.compile("//(.)\n(.*)").matcher(text);
		match.matches();

		String checkDelimiter = match.group(1);
		String numbers = match.group(2);
		return numbers.split(checkDelimiter);
	}

    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }

}