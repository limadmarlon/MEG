package Main;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

import lexical.LexAnalyzer;
import sintatical.ParserTable;

public class MainTestSintax {
	
	Integer entry;
	Stack<Integer> stack;
	static ParserTable table;
	LexAnalyzer code;
	
	
	public static void main(String[] args) {
		String code = new File("/AnalisadorLexicoMEG/src/fibonacci.meg").;
		
		table = new ParserTable();
		code = new LexAnalyzer(code);
	}
	
	private void state(Stack stack, Integer entry){
		
	}
}
