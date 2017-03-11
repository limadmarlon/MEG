package lexical;

import lexical.LexicalTable;
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
				return new Token();
			}else{
				//implement last token
				return new Token();
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
		if(code.charAt(count) == '&') {count++; return new Token();}
		if(code.charAt(count) == '|') {count++; return new Token();}
		
		categ = tkCateg.tkOpr_neg;
		if(code.charAt(count) == '!') {count++; return new Token();}

		categ = tkCateg.tkOpr_sum;
		if(code.charAt(count) == '-') {count++; return new Token();}
		if(code.charAt(count) == '+'){
			if(code.charAt(count+1) == '+'){
				//implement concat
				categ = tkCateg.tkOpr_concat;
				count=+2;
				return new Token();
			}else{						
				//implement plus
				count++;
				return new Token();
			}
		}
		
		categ = tkCateg.tkOpr_mul;
		if(code.charAt(count) == '*') {count++; return new Token();}
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
			return new Token();
		}
		
		categ = tkCateg.tkOpr_att;
		if(code.charAt(count) == '=') {count++; return new Token();}
		
		categ = tkCateg.tkOpr_r;
		if(code.charAt(count) == '<') {count++; return new Token();}
		if(code.charAt(count) == '>') {count++; return new Token();}
		if(code.charAt(count) == '<' && code.charAt(count+1) == '=') {count+=2; return new Token();}
		if(code.charAt(count) == '>' && code.charAt(count+1) == '=') {count+=2; return new Token();}
		if(code.charAt(count) == '=' && code.charAt(count+1) == '=') {count+=2; return new Token();}
		
		categ = tkCateg.tkOpr_index_enter;
		if(code.charAt(count) == '[') {count++; return new Token();}
		
		categ = tkCateg.tkOpr_index_out;
		if(code.charAt(count) == ']') {count++; return new Token();}
		
		categ = tkCateg.tkDel_comma;
		if(code.charAt(count) == ',') {count++; return new Token();}
		
		categ = tkCateg.tkDel_par_enter;
		if(code.charAt(count) == '(') {count++; return new Token();}
		
		categ = tkCateg.tkDel_par_out;
		if(code.charAt(count) == ')') {count++; return new Token();}
		
		categ = tkCateg.tkDel_bra_enter;
		if(code.charAt(count) == '{') {count++; return new Token();}
		
		categ = tkCateg.tkDel_bra_out;
		if(code.charAt(count) == '}') {count++; return new Token();}
		
		categ = tkCateg.tkDel_dot;
		if(code.charAt(count) == '.') {count++; return new Token();}
		
		categ = tkCateg.tkDel_scolon;
		if(code.charAt(count) == ';') {count++; return new Token();}
		
		categ = tkCateg.tkDel_colon;
		if(code.charAt(count) == ':') {count++; return new Token();}
		
		categ = tkCateg.tkDel_comma;
		if(code.charAt(count) == ',') {count++; return new Token();}
		
		categ = tkCateg.tkLit_bool;
		if(code.charAt(count) == '#') {	
			count++;
			if(code.charAt(count) == 'T') {count++; return new Token();}
			else if (code.charAt(count) == 'F') {count++; return new Token();}
			else {count ++; return new Token();}//error
		}
			
		////////////////char literal//////////
		categ = tkCateg.tkLit_char;
		if(code.charAt(count) == '\'') {	
			tokenName = "";
			count++;
			while(!(code.charAt(count) == '\'') || (code.charAt(count-1) == '\\'))
				tokenName.concat(Character.toString(code.charAt(count)));
			count++;
			return new Token();
		}
		
		//////////////////string literal//////////////
		categ = tkCateg.tkLit_string;
		if(code.charAt(count) == '"') {	
			tokenName = "";
			count++;
			while(!(code.charAt(count) == '"') || (code.charAt(count-1) == '\\'))
				tokenName.concat(Character.toString(code.charAt(count)));
			count++;
			return new Token();
		}
		
		///////literal Number/////////////////////////
		categ = tkCateg.tkLit_int;
		if(Character.isDigit(code.charAt(count))){
			tokenName = "";
			boolean isInt = true;
			while((Character.isDigit(code.charAt(count)) || code.charAt(count) == '.')){
				tokenName.concat(Character.toString(code.charAt(count)));
				if(code.charAt(count) =='.'){
					categ = tkCateg.tkLit_float;
					count++;
					while(Character.isDigit(code.charAt(count))){
						tokenName.concat(Character.toString(code.charAt(count)));
						count++;
					}
					//return tkLit_float
					return new Token();
				}else{
					count++;
				}
			}
			//return tkLit_float
			return new Token();
		}
		
		//////////words/////////////////////////////////
		
		if(Character.isAlphabetic(code.charAt(count))){
			categ = tkCateg.tkId;
			
			
			///////////////tipos///////////////////////
			if(	code.charAt(count  ) == 'i' && 
				code.charAt(count+1) == 'n' && 
				code.charAt(count+2) == 't')
			{
				count+=3;
				categ = tkCateg.tkType_int;
				return new Token();
			}
			
			if(	code.charAt(count  ) == 'f' && 
				code.charAt(count+1) == 'l' && 
				code.charAt(count+2) == 'o' &&
				code.charAt(count+3) == 'a' &&
				code.charAt(count+4) == 't')
			{
				count+=5;
				categ = tkCateg.tkType_float;
				return new Token();
			}
			
			if(	code.charAt(count  ) == 'c' && 
				code.charAt(count+1) == 'h' && 
				code.charAt(count+2) == 'a' &&
				code.charAt(count+3) == 'r' )
			{
				count+=4;
				categ = tkCateg.tkType_char;
				return new Token();
			}
			
			if(	code.charAt(count  ) == 'b' && 
				code.charAt(count+1) == 'o' && 
				code.charAt(count+2) == 'o' &&
				code.charAt(count+3) == 'l' )
			{
				count+=4;
				categ = tkCateg.tkType_bool;
				return new Token();
			}
			
			if(	code.charAt(count  ) == 's' && 
				code.charAt(count+1) == 't' && 
				code.charAt(count+2) == 'r' &&
				code.charAt(count+3) == 'i' &&
				code.charAt(count+4) == 'n' &&
				code.charAt(count+5) == 'g')
			{
				count+=6;
				categ = tkCateg.tkType_string;
				return new Token();
			}
			
			if(	code.charAt(count  ) == 'a' && 
				code.charAt(count+1) == 'r' && 
				code.charAt(count+2) == 'r' &&
				code.charAt(count+3) == 'a' &&
				code.charAt(count+4) == 'y')
			{
				count+=5;
				categ = tkCateg.tkType_array;
				return new Token();
			}
			
			
			////////////////reserved words/////////////////////
			if(	code.charAt(count  ) == 'i' && 
				code.charAt(count+1) == 'f' )
			{
				count+=2;
				categ = tkCateg.tk_if;
				return new Token();
			}
			
			if(	code.charAt(count  ) == 'e' && 
				code.charAt(count+1) == 'l' && 
				code.charAt(count+2) == 's' && 
				code.charAt(count+3) == 'e')
			{
				count+=4;
				categ = tkCateg.tk_else;
				return new Token();
			}
			
			if(	code.charAt(count  ) == 'w' && 
				code.charAt(count+1) == 'h' && 
				code.charAt(count+2) == 'i' && 
				code.charAt(count+3) == 'l' && 
				code.charAt(count+4) == 'e')
			{
				count+=5;
				categ = tkCateg.tk_while;
				return new Token();
			}
			
			if(	code.charAt(count  ) == 't' && 
				code.charAt(count+1) == 'h' && 
				code.charAt(count+2) == 'e' && 
				code.charAt(count+3) == 'n')
			{
				count+=4;
				categ = tkCateg.tk_then;
				return new Token();
			}
			
			if(	code.charAt(count  ) == 'd' && 
				code.charAt(count+1) == 'o')
			{
				count+=2;
				categ = tkCateg.tk_do;
				return new Token();
			}
			
			if(	code.charAt(count  ) == 'i' && 
				code.charAt(count+1) == 'n' )
			{
				count+=2;
				categ = tkCateg.tk_in;
				return new Token();
			}
			
			if(	code.charAt(count  ) == 'f' && 
				code.charAt(count+1) == 'o' && 
				code.charAt(count+2) == 'r')
			{
				count+=3;
				categ = tkCateg.tk_for;
				return new Token();
			}
			if(	code.charAt(count  ) == 'o' && 
				code.charAt(count+1) == 'u' && 
				code.charAt(count+2) == 't')
			{
				count+=3;
				categ = tkCateg.tk_out;
				return new Token();
			}
			if(	code.charAt(count  ) == 'r' && 
				code.charAt(count+1) == 'e' && 
				code.charAt(count+2) == 't' && 
				code.charAt(count+3) == 'u' && 
				code.charAt(count+4) == 'r' && 
				code.charAt(count+5) == 'n')
			{
				count+=6;
				categ = tkCateg.tk_return;
				return new Token();
			}
			if(	code.charAt(count  ) == 'e' && 
				code.charAt(count+1) == 'n' && 
				code.charAt(count+2) == 'd')
			{
				count+=3;
				categ = tkCateg.tk_do;
				return new Token();
			}
			
			if(	code.charAt(count  ) == 'm' && 
				code.charAt(count+1) == 'a' && 
				code.charAt(count+2) == 'i' && 
				code.charAt(count+3) == 'n')
			{
				count+=4;
				categ = tkCateg.tkMain;
				return new Token();
			}
			
			tokenName = "";
			
			while(Character.isAlphabetic(code.charAt(count)) || code.charAt(count) == '_' ){
				tokenName.concat(Character.toString(code.charAt(count)));
				if(code.charAt(count) =='_'){
					if(code.charAt(count) == '_'){
						//error
					}
					count++;
				}else{
					count++;
				}
			}
			
			//return tkId
			return new Token();
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