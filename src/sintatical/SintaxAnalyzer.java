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
	private ParserTable table =  new ParserTable() ;
	
	public SintaxAnalyzer(String code) {

		
	}
	
	private void CreateAD(){
		
	}

	
}
