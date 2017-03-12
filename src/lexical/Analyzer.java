package lexical;

import lexical.Token;
import lexical.tkCateg;

public class Analyzer {

	private String code;
	private String tokenName;
	private tkCateg categ;
	private int count;
	private int initToken;
	
	public Analyzer(String code) {
		super();
		this.code = code;
		this.count = 0;
		this.initToken = 0;
	}
	
	public Token nextToken(){
		try{
			
			return nextToken2();
			
		}catch (StringIndexOutOfBoundsException e) {
			if(categ == tkCateg.tk_start){
				//EOF implement
				return new Token("",tkCateg.tk_EOF,-1);
			}else{
				//implement last token
				count = code.length();
				return new Token(code.substring(initToken, code.length()),categ,initToken);
			}
			
		}
	}
	
	private Token nextToken2() throws StringIndexOutOfBoundsException{
		categ = tkCateg.tk_start;
		initToken = count;
		
		ignoreSpecial();

		//garante que nï¿½o irï¿½ lanï¿½ar um exception 
		//code.charAt(count);
		
		categ = tkCateg.tkOpr_log;
		if(code.charAt(count) == '&') {count++; return new Token("&",categ,initToken);}
		if(code.charAt(count) == '|') {count++; return new Token("|",categ,initToken);}
		
		categ = tkCateg.tkOpr_neg;
		if(code.charAt(count) == '!') {count++; return new Token("!",categ,initToken);}

		categ = tkCateg.tkOpr_sum;
		if(code.charAt(count) == '-') {count++; return new Token("-",categ,initToken);}
		if(code.charAt(count) == '+'){
			if(code.charAt(count+1) == '+'){
				//implement concat
				categ = tkCateg.tkOpr_concat;
				count=+2;
				return new Token("++",categ,initToken);
			}else{						
				//implement plus
				count++;
				return new Token("+",categ,initToken);
			}
		}
		
		categ = tkCateg.tkOpr_mul;
		if(code.charAt(count) == '*') {count++; return new Token("*",categ,initToken);}
		if(code.charAt(count) == '/'){
			//commandblock/////////////////////
			if(code.charAt(count + 1) == '*'){
				if(code.charAt(count + 2) == '*'){
					categ=tkCateg.tk_start;
					count+=3;
					ignoreCommentBlock();
					return nextToken();
				}
			}
			//ComentLine///////////////////////
			if(code.charAt(count) == '/'){
				categ=tkCateg.tk_start;
				count+=2;
				ignoreCommentLine();
				return nextToken();
			}
			//Division
			count++;
			return new Token("/",categ,initToken);
		}
		
		categ = tkCateg.tkOpr_att;
		if(code.charAt(count) == '=') {count++; return new Token("=",categ,initToken);}
		
		categ = tkCateg.tkOpr_r;
		if(code.charAt(count) == '<') {count++; return new Token("<",categ,initToken);}
		if(code.charAt(count) == '>') {count++; return new Token(">",categ,initToken);}
		if(code.charAt(count) == '<' && code.charAt(count+1) == '=') {count+=2; return new Token("<=",categ,initToken);}
		if(code.charAt(count) == '>' && code.charAt(count+1) == '=') {count+=2; return new Token(">=",categ,initToken);}
		if(code.charAt(count) == '=' && code.charAt(count+1) == '=') {count+=2; return new Token("==",categ,initToken);}
		
		categ = tkCateg.tkOpr_index_enter;
		if(code.charAt(count) == '[') {count++; return new Token("[",categ,initToken);}
		
		categ = tkCateg.tkOpr_index_out;
		if(code.charAt(count) == ']') {count++; return new Token("]",categ,initToken);}
		
		categ = tkCateg.tkDel_comma;
		if(code.charAt(count) == ',') {count++; return new Token(",",categ,initToken);}
		
		categ = tkCateg.tkDel_par_enter;
		if(code.charAt(count) == '(') {count++; return new Token("(",categ,initToken);}
		
		categ = tkCateg.tkDel_par_out;
		if(code.charAt(count) == ')') {count++; return new Token(")",categ,initToken);}
		
		categ = tkCateg.tkDel_bra_enter;
		if(code.charAt(count) == '{') {count++; return new Token("{",categ,initToken);}
		
		categ = tkCateg.tkDel_bra_out;
		if(code.charAt(count) == '}') {count++; return new Token("}",categ,initToken);}
		
		categ = tkCateg.tkDel_dot;
		if(code.charAt(count) == '.') {count++; return new Token(".",categ,initToken);}
		
		categ = tkCateg.tkDel_scolon;
		if(code.charAt(count) == ';') {count++; return new Token(";",categ,initToken);}
		
		categ = tkCateg.tkDel_colon;
		if(code.charAt(count) == ':') {count++; return new Token(":",categ,initToken);}
		
		categ = tkCateg.tkDel_comma;
		if(code.charAt(count) == ',') {count++; return new Token(",",categ,initToken);}
		
		categ = tkCateg.tkLit_bool;
		if(code.charAt(count) == '#') {	
			count++;
			if(code.charAt(count) == 'T') {count++; return new Token("#T",categ,initToken);}
			else if (code.charAt(count) == 'F') {count++; return new Token("#F",categ,initToken);}
			else {count ++; return new Token(code.substring(initToken, count),categ,initToken);}//error
		}
			
		////////////////char literal//////////
		categ = tkCateg.tkLit_char;
		if(code.charAt(count) == '\'') {	
			tokenName = "";
			count++;
			while(!(code.charAt(count) == '\'') || (code.charAt(count-1) == '\\')){
				tokenName = tokenName.concat(Character.toString(code.charAt(count)));
				count++;
			}
			count++;
			return new Token(tokenName,categ,initToken);
		}
		
		//////////////////string literal//////////////
		categ = tkCateg.tkLit_string;
		if(code.charAt(count) == '"') {	
			tokenName = "";
			count++;
			while(!(code.charAt(count) == '"') || (code.charAt(count-1) == '\\')){
				tokenName = tokenName.concat(Character.toString(code.charAt(count)));
				count++;
			}
			count++;
			return new Token(tokenName,categ,initToken);
		}
		
		///////literal Number/////////////////////////
		categ = tkCateg.tkLit_int;
		if(Character.isDigit(code.charAt(count))){
			tokenName = "";
			while((Character.isDigit(code.charAt(count)) || code.charAt(count) == '.')){
				tokenName = tokenName.concat(Character.toString(code.charAt(count)));
				if(code.charAt(count) =='.'){
					categ = tkCateg.tkLit_float;
					if(!Character.isDigit(code.charAt(count+1)))
						categ = tkCateg.tk_error;
					
					count++;
					while(Character.isDigit(code.charAt(count))){
						tokenName = tokenName.concat(Character.toString(code.charAt(count)));
						count++;
					}
					//return tkLit_float
					return new Token(tokenName,categ,initToken);
				}else{
					count++;
				}
			}
			//return tkLit_float
			return new Token(tokenName,categ,initToken);
		}
		
		//////////words/////////////////////////////////
		
		if(Character.isAlphabetic(code.charAt(count))){
			categ = tkCateg.tkId;
			
			
			///////////////tipos///////////////////////
			categ = tkCateg.tkType_int;
			if(	code.charAt(count  ) == 'i' && 
				code.charAt(count+1) == 'n' && 
				code.charAt(count+2) == 't' &&
				!(Character.isAlphabetic(code.charAt(count+3)) || code.charAt(count+3) == '_'))
			{
				count+=3;
				
				return new Token("int",categ,initToken);
			}
			
			categ = tkCateg.tkType_float;
			if(	code.charAt(count  ) == 'f' && 
				code.charAt(count+1) == 'l' && 
				code.charAt(count+2) == 'o' &&
				code.charAt(count+3) == 'a' &&
				code.charAt(count+4) == 't' &&
				!(Character.isAlphabetic(code.charAt(count+5)) || code.charAt(count+5) == '_'))
			{
				count+=5;
				
				return new Token("float",categ,initToken);
			}
			
			categ = tkCateg.tkType_char;
			if(	code.charAt(count  ) == 'c' && 
				code.charAt(count+1) == 'h' && 
				code.charAt(count+2) == 'a' &&
				code.charAt(count+3) == 'r'  &&
				!(Character.isAlphabetic(code.charAt(count+4)) || code.charAt(count+4) == '_'))
			{
				count+=4;
				
				return new Token("char",categ,initToken);
			}
			
			categ = tkCateg.tkType_bool;
			if(	code.charAt(count  ) == 'b' && 
				code.charAt(count+1) == 'o' && 
				code.charAt(count+2) == 'o' &&
				code.charAt(count+3) == 'l'  &&
				!(Character.isAlphabetic(code.charAt(count+4)) || code.charAt(count+4) == '_'))
			{
				count+=4;
				
				return new Token("bool",categ,initToken);
			}
			
			categ = tkCateg.tkType_string;
			if(	code.charAt(count  ) == 's' && 
				code.charAt(count+1) == 't' && 
				code.charAt(count+2) == 'r' &&
				code.charAt(count+3) == 'i' &&
				code.charAt(count+4) == 'n' &&
				code.charAt(count+5) == 'g' &&
				!(Character.isAlphabetic(code.charAt(count+6)) || code.charAt(count+6) == '_'))
			{
				count+=6;
				
				return new Token("string",categ,initToken);
			}
			
			categ = tkCateg.tkType_array;
			if(	code.charAt(count  ) == 'a' && 
				code.charAt(count+1) == 'r' && 
				code.charAt(count+2) == 'r' &&
				code.charAt(count+3) == 'a' &&
				code.charAt(count+4) == 'y' &&
				!(Character.isAlphabetic(code.charAt(count+5)) || code.charAt(count+5) == '_'))
			{
				count+=5;
				
				return new Token("array",categ,initToken);
			}
			
			
			////////////////reserved words/////////////////////
			categ = tkCateg.tk_if;
			if(	code.charAt(count  ) == 'i' && 
				code.charAt(count+1) == 'f'  &&
				!(Character.isAlphabetic(code.charAt(count+2)) || code.charAt(count+2) == '_'))
			{
				count+=2;
				
				return new Token("if",categ,initToken);
			}
			
			categ = tkCateg.tk_else;
			if(	code.charAt(count  ) == 'e' && 
				code.charAt(count+1) == 'l' && 
				code.charAt(count+2) == 's' && 
				code.charAt(count+3) == 'e' &&
				!(Character.isAlphabetic(code.charAt(count+4)) || code.charAt(count+4) == '_'))
			{
				count+=4;
				
				return new Token("else",categ,initToken);
			}
			
			categ = tkCateg.tk_while;
			if(	code.charAt(count  ) == 'w' && 
				code.charAt(count+1) == 'h' && 
				code.charAt(count+2) == 'i' && 
				code.charAt(count+3) == 'l' && 
				code.charAt(count+4) == 'e' &&
				!(Character.isAlphabetic(code.charAt(count+5)) || code.charAt(count+5) == '_'))
			{
				count+=5;
				
				return new Token("while",categ,initToken);
			}
			
			categ = tkCateg.tk_then;
			if(	code.charAt(count  ) == 't' && 
				code.charAt(count+1) == 'h' && 
				code.charAt(count+2) == 'e' && 
				code.charAt(count+3) == 'n' &&
				!(Character.isAlphabetic(code.charAt(count+4)) || code.charAt(count+4) == '_'))
			{
				count+=4;
				
				return new Token("then",categ,initToken);
			}
			
			categ = tkCateg.tk_do;
			if(	code.charAt(count  ) == 'd' && 
				code.charAt(count+1) == 'o' &&
				!(Character.isAlphabetic(code.charAt(count+2)) || code.charAt(count+2) == '_'))
			{
				count+=2;
				
				return new Token("do",categ,initToken);
			}
			
			categ = tkCateg.tk_in;
			if(	code.charAt(count  ) == 'i' && 
				code.charAt(count+1) == 'n'  &&
				!(Character.isAlphabetic(code.charAt(count+2)) || code.charAt(count+2) == '_'))
			{
				count+=2;
				
				return new Token("in",categ,initToken);
			}
			
			categ = tkCateg.tk_for;
			if(	code.charAt(count  ) == 'f' && 
				code.charAt(count+1) == 'o' && 
				code.charAt(count+2) == 'r' &&
				!(Character.isAlphabetic(code.charAt(count+3)) || code.charAt(count+3) == '_'))
			{
				count+=3;
				
				return new Token("for",categ,initToken);
			}
			
			categ = tkCateg.tk_out;
			if(	code.charAt(count  ) == 'o' && 
				code.charAt(count+1) == 'u' && 
				code.charAt(count+2) == 't' &&
				!(Character.isAlphabetic(code.charAt(count+3)) || code.charAt(count+3) == '_'))
			{
				count+=3;
				
				return new Token("out",categ,initToken);
			}
			
			categ = tkCateg.tk_return;
			if(	code.charAt(count  ) == 'r' && 
				code.charAt(count+1) == 'e' && 
				code.charAt(count+2) == 't' && 
				code.charAt(count+3) == 'u' && 
				code.charAt(count+4) == 'r' && 
				code.charAt(count+5) == 'n' &&
				!(Character.isAlphabetic(code.charAt(count+6)) || code.charAt(count+6) == '_'))
			{
				count+=6;
				
				return new Token("return",categ,initToken);
			}
			
			categ = tkCateg.tk_end;
			if(	code.charAt(count  ) == 'e' && 
				code.charAt(count+1) == 'n' && 
				code.charAt(count+2) == 'd' &&
				!(Character.isAlphabetic(code.charAt(count+3)) || code.charAt(count+3) == '_'))
			{
				count+=3;
				
				return new Token("end",categ,initToken);
			}
			
			categ = tkCateg.tkMain;
			if(	code.charAt(count  ) == 'm' && 
				code.charAt(count+1) == 'a' && 
				code.charAt(count+2) == 'i' && 
				code.charAt(count+3) == 'n' &&
				!(Character.isAlphabetic(code.charAt(count+4)) || code.charAt(count+4) == '_'))
			{
				count+=4;
				
				return new Token("main",categ,initToken);
			}
			
			tokenName = "";
			
			while(Character.isAlphabetic(code.charAt(count)) || code.charAt(count) == '_' ){
				tokenName = tokenName.concat(Character.toString(code.charAt(count)));
				if(code.charAt(count) =='_'){
					if(code.charAt(count+1) == '_'){
						categ = tkCateg.tk_error;
					}
					count++;
				}else{
					count++;
				}
			}
			
			//return tkId
			return new Token(tokenName,categ,initToken);
		}
		
		//////////literal array acredito que não precisa///////////
		
		
		
		return null;
	}
	
	
	private void ignoreSpecial() throws StringIndexOutOfBoundsException{
		while(code.charAt(count) == ' ' || code.charAt(count) == '\n'){
				count++;
				initToken++;
		}
	}
	private void ignoreCommentBlock() throws StringIndexOutOfBoundsException{
		boolean outOfBlock=false;
		
		while(!outOfBlock){
			
			if(code.charAt(count) == '*'){
				if(code.charAt(count+1) == '*'){
					if(code.charAt(count+2) == '/'){
						outOfBlock = true;
					}
				}
			}
			count+=3;
		}
	}
	
	private void ignoreCommentLine() throws StringIndexOutOfBoundsException{
		while(!(code.charAt(count) == '\n')){
				count++;
				initToken++;
		}
		count++;
	}
}