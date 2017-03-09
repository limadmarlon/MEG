package lexical;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

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

		//garante que não irá lançar um exception 
		code.charAt(count);
		
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
				categ = tkCateg.tk_start;
				count = initToken;
			}
			//ComentLine///////////////////////
			if(code.charAt(count) == '/'){
				categ=tkCateg.tk_start;
				count+=2;
				ignoreCommentLine();
				return nextToken();
			}
			count++;
			return new Token();
		}
		
		categ = tkCateg.tkOpr_r;
		if(code.charAt(count) == '<') {count++; return new Token();}
		if(code.charAt(count) == '>') {count++; return new Token();}
		if(code.charAt(count) == '<' && code.charAt(count) == '=') {count+=2; return new Token();}
		if(code.charAt(count) == '>' && code.charAt(count) == '=') {count+=2; return new Token();}
		if(code.charAt(count) == '=' && code.charAt(count) == '=') {count+=2; return new Token();}
		
		categ = tkCateg.tkOpr_index_enter;
		if(code.charAt(count) == '[') {count++; return new Token();}
		
		categ = tkCateg.tkOpr_index_out;
		if(code.charAt(count) == ']') {count++; return new Token();}
		
		categ = tkCateg.tkDel_comma;
		if(code.charAt(count) == ',') {count++; return new Token();}
		
		/////////////////////////////////////////////
		//////////id/////////////////////////////////
		if(Character.isAlphabetic(code.charAt(count))){
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
		//////////////////////////////////////////////
		///////literal Number/////////////////////////
		if(Character.isDigit(code.charAt(count))){
			tokenName = "";
			boolean isInt = true;
			while(Character.isDigit(code.charAt(count)) || code.charAt(count) == '.' ){
				tokenName.concat(Character.toString(code.charAt(count)));
				if(code.charAt(count) =='.'){
					count++;
					if(Character.isDigit(code.charAt(count))){
						tokenName.concat(Character.toString(code.charAt(count)));
						isInt = false;
					}else{
						//error
					}
					count++;
				}else{
					count++;
				}
			}
			if(isInt){
			//return tkLit_int
				return new Token();
			}else{
				//return tkLit_float
				return new Token();
			}
		}
		
		
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
			count++;
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