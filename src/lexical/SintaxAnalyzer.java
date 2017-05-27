package lexical;

import java.util.ArrayList;

import lexical.LexAnalyzer;

public class SintaxAnalyzer {
	
	private LexAnalyzer T ;
	public SyntaxNode head;
	private Token A;
	
	public SintaxAnalyzer(String code) {
		T = new LexAnalyzer(code);
		head = Code();
		
	}
	

private SyntaxNode Code{}
private SyntaxNode Coder{}

//private SyntaxNode Decl_function{}

//private SyntaxNode Main{}

private SyntaxNode Decl_Main{}

private SyntaxNode Main_function{}

private SyntaxNode Main_process{}

private SyntaxNode FunCall{}
private SyntaxNode FunCallParam{}
private SyntaxNode FunCallParamr{}


private SyntaxNode Decl{}

private SyntaxNode Type{}

private SyntaxNode String_Type{}
private SyntaxNode Number_Type{}

private SyntaxNode Decl_param_list{}


private SyntaxNode Statements{}
private SyntaxNode Statementsr{}

private SyntaxNode Statement{}

private SyntaxNode ATT{}
private SyntaxNode ATTr{}

private SyntaxNode Exp{}
private SyntaxNode Exp{}
private SyntaxNode Exp{}
private SyntaxNode Exp{}
private SyntaxNode Exp{}
private SyntaxNode Exp{}
private SyntaxNode Exp{}

private SyntaxNode Exp_aritm{}
private SyntaxNode Exp_aritmr{}
private SyntaxNode Exp_aritm2{}
private SyntaxNode Exp_aritm2r{}
private SyntaxNode Exp_aritm3{}
private SyntaxNode Exp_aritm4{}
private SyntaxNode value_aritm{}
private SyntaxNode Index{}

private SyntaxNode Exp_rel{}
private SyntaxNode Exp_rel_param{}

private SyntaxNode Exp_log{}
private SyntaxNode Exp_logr{}
private SyntaxNode Exp_log2{}
private SyntaxNode Exp_log3{}
private SyntaxNode value_log{}

private SyntaxNode Cast{}
private SyntaxNode CastParam{}

private SyntaxNode Cast_Type{}

private SyntaxNode Concat{}
private SyntaxNode Concat2{}

private SyntaxNode Output{}

private SyntaxNode IF_THEN{}
private SyntaxNode ELSE{}

private SyntaxNode WHILE{}
private SyntaxNode WHILE_THEN{}
private SyntaxNode DO_WHILE{}

private SyntaxNode FOR{}

	
}
