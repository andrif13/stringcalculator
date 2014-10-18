package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class CalculatorTest {


	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }
     @Test
    public void testUnknownArguments(){
    	assertEquals(12, Calculator.add("1,2,1,2,1,2,1,2"));
    }

    @Test
    public void testNewLines(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }
    
    @Test
    public void testAcceptedCustomDelimeters(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }
    @Test
    public void testignore1000(){
    	assertEquals(2, Calculator.add("2,1001"));
    }

    @Test
    public void negativeNumberThrowsAnException(){
    	try{
    		Calculator.add("-1,2");
    	} catch(RuntimeException ex) {
    		assertEquals("Negatives not allowed: ,-1", ex.getMessage());
    	}
    }
    

     @Test
    public void negativeNumberMoreThanOneThrowsAnException(){
    	try{
    		Calculator.add("2,-4,3,-5");
    	} catch(RuntimeException ex) {
    		assertEquals("Negatives not allowed: ,-4,-5", ex.getMessage());
    	}
    }
    @Test
    public void Delimeterofeverysize(){
    	assertEquals(6, Calculator.add("//;;;\n1;;;2;;;3"));
    }
   
}