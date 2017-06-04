package sintatical;

import java.util.ArrayList;
import java.util.Stack;

import lexical.LexAnalyzer;
import lexical.Token;

public class SintaxAnalyzer {
	
	private LexAnalyzer T ;
	public SyntaxNode head;
	private Token A;
	private Stack<Integer> sintaxStack;
	
	public SintaxAnalyzer(String code) {
		T = new LexAnalyzer(code);
		sintaxStack =  new Stack<Integer>();
		SintaxStack.push(ntCateg.ntCode.getCategValue());
		CreateAD();
		
	}
	
	private void CreateAD(){
		
	}

	
}
