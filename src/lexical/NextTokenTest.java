package lexical;

import static org.junit.Assert.*;

import org.junit.Test;

public class NextTokenTest {

	@Test
	public void NextTokentest() {
		String entrada = "{}";
		Analyzer anal = new Analyzer(entrada);
		
		String result = anal.nextToken().getValue();
		result = result + anal.nextToken().getValue();
		System.out.println(anal.nextToken().getCategory());
		assertEquals("{}", result);
	}
	
	@Test
	public void HWtest() {
		String entrada = "if( a <= 2) then";
		Analyzer anal = new Analyzer(entrada);
		String result = anal.nextToken().getValue();
		for(int i = 0; i < 12; i++){
			result = result + anal.nextToken().getValue();
		}
		System.out.println(result);
		assertEquals("if(a<=2)then", result);

	}

}
