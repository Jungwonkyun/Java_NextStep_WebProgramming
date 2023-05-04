package stringcalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

	private StringCalculator cal;
	
	@Before
	public void setup() {
		cal = new StringCalculator();
	}
	
	@Test
	public void add_null() {
		//null값 또는 빈 문자열을 넣었을 때 
		assertEquals(0, cal.add(null));
		assertEquals(0, cal.add(""));
	}
	
	@Test
	public void add_oneNum() throws Exception {
		//숫자 하나를 문자열로 넣었을 때 
		assertEquals(1, cal.add("1"));
	}
	
	@Test
	public void add_shimpyo() {
		//숫자 두개를 쉼표로 구분된 문자열을 넣었을 때 
		assertEquals(3, cal.add("1,2"));
	}
	
	@Test
	public void add_shimOrCol() {
		//숫자가 쉼표 또는 콜론으로 구분된 문자열을 넣었을 때 
		assertEquals(6, cal.add("1,2:3"));
	}
	
	@Test
	public void add_custom() throws Exception{
		//커스텀 문자열이 들어오면 
		assertEquals(6, cal.add("//;\n1;2;3"));
	}
	
	@Test(expected = RuntimeException.class)
	public void add_negative() throws Exception{
		cal.add("-1,2,3");
	}
	
}