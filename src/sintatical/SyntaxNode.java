package sintatical;

import java.util.ArrayList;

import lexical.Token;

public class SyntaxNode {
	
	protected Token tk;
	protected ArrayList<SyntaxNode> sons = new ArrayList<>();	
	
	public SyntaxNode(Token tk, ArrayList<SyntaxNode> sons) {
		
		this.tk = tk;
		this.sons = sons;
		
		// TODO Auto-generated constructor stub
	}

}
