package is.ru.stringcalculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
public class Calculator {

private static String negativecheck = "Negatives not allowed: ";

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
		else if(text.contains("-")){
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
			if(numbers.contains(";;"))
			{
				return splitByrandomLength(numbers);
			}
			return splitCustomDelimiter(numbers);
		}
		else if(numbers.contains("-"))
		{
			String[] tokens = numbers.split(",|\n");
			int total1 = 0;
			String nr = "";

			for(String negative : tokens) 
			{
				if(toInt(negative) < 0)
				{
					nr += "," + negative ;
				}
			}
			throw new RuntimeException("Negatives not allowed: " + nr);
		}
		else
		{
			
			String[] replaced = numbers.split(",|\n");
	    	return replaced;
		}
	}

	private static String[] splitByrandomLength(String numbers) {
		Matcher m = Pattern.compile("//(?<delimiter>.*)\n(?<value>.*)").matcher(numbers);
	    m.matches();
	    String delimiter = m.group(1);
	    String num = m.group(2);
	    return num.split(delimiter);
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
        	if(toInt(number) > 1000)
        	{
        		continue;
        	}
		    total += toInt(number);
		}
		return total;
    }

}