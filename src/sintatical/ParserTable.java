package sintatical;


import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import lexical.tkCateg;

public class ParserTable {
	
	private LinkedList<Integer>[][] table;

	
	public ParserTable() {
		super();
		table = new LinkedList[47][50];
		
		//------------------- Produção -------------------//
		//------------------- Code = Decl_Main Coder -------------------//
		
		int j=0;
		for (LinkedList<Integer> linkedList : table[ntCateg.ntCode.getCategValue() - 51]) {
			
			if(isFirstType(j))			
				table[ntCateg.ntCode.getCategValue() - 51][j].addAll(CTLL(
					new Integer[]{	ntCateg.ntDecl_Main.getCategValue(),
									ntCateg.ntCoder.getCategValue()}));
			
			else table[ntCateg.ntCode.getCategValue() - 51][j]=null;
			
			j++;
		}
		
		//--------------------------------------------------------------//
		
		//------------------- Coder= “;” Decl_Main Coder | ε -------------------//
		
		j=0;
		for (LinkedList<Integer> linkedList : table[ntCateg.ntCoder.getCategValue() - 51]) {
		
			if(j == tkCateg.tkDel_scolon.getCategValue() -1) 	
				table[ntCateg.ntCoder.getCategValue() - 51][j].addAll(CTLL(
					new Integer[]{	tkCateg.tkDel_scolon.getCategValue(),
									ntCateg.ntDecl_Main.getCategValue(),
									ntCateg.ntCoder.getCategValue()}));
			
			else if(j == tkCateg.tk_EOF.getCategValue() -1) 	
				table[ntCateg.ntCoder.getCategValue() - 51][j].addAll(CTLL(
					new Integer[]{}));
			
			else 
				table[ntCateg.ntCoder.getCategValue() - 51][j]=null;
			
			j++;
		
		}
		
		//--------------------------------------------------------------//
		
		//------------------- Decl_Main = Type Main_function -------------------//
		
		j=0;
		for (LinkedList<Integer> linkedList : table[ntCateg.ntDecl_Main.getCategValue() - 51]) {
			
			if(isFirstType(j))			
				table[ntCateg.ntDecl_Main.getCategValue() - 51][j].addAll(CTLL(
					new Integer[]{	ntCateg.ntType.getCategValue(),
									ntCateg.ntMain_function.getCategValue()}));
			
			else table[ntCateg.ntDecl_Main.getCategValue() - 51][j]=null;
			
			j++;
		}
		//--------------------------------------------------------------//
		
		//------------------- Main_function = “Id” “(” Decl_param_list “)” “{” Statements_return “}” Main_function | “main” Main_process -------------------//
		
		j=0;
		for (LinkedList<Integer> linkedList : table[ntCateg.ntMain_function.getCategValue() - 51]) {
		
			if(j == tkCateg.tkId.getCategValue() -1) 
				table[ntCateg.ntMain_function.getCategValue() - 51][j].addAll(CTLL(
					new Integer[]{	tkCateg.tkId.getCategValue(),
									tkCateg.tkDel_par_enter.getCategValue(),
									ntCateg.ntDecl_param_list.getCategValue(),
									tkCateg.tkDel_par_out.getCategValue(),
									tkCateg.tkDel_bra_enter.getCategValue(),
									ntCateg.ntStatements_return.getCategValue(),
									tkCateg.tkDel_bra_out.getCategValue(),
									ntCateg.ntMain_function.getCategValue()}));
			
			else if(j == tkCateg.tkMain.getCategValue() -1)
				table[ntCateg.ntMain_function.getCategValue() - 51][j].addAll(CTLL(
					new Integer[]{	tkCateg.tkMain.getCategValue(),
									ntCateg.ntMain_process.getCategValue()}));
			
			else 
				table[ntCateg.ntMain_function.getCategValue() - 51][j]=null;
			
			j++;
			
		}
		//--------------------------------------------------------------//
		
		
		//------------------- Main_process = “(” “)” “{” Statements_main “}” “;” -------------------//
		
		j=0;
		for (LinkedList<Integer> linkedList : table[ntCateg.ntMain_process.getCategValue() - 51]) {
		
			if(j == tkCateg.tkDel_par_enter.getCategValue() - 1)
				table[ntCateg.ntMain_process.getCategValue() - 51][j].addAll(CTLL(
					new Integer[]{	tkCateg.tkDel_par_enter.getCategValue(),
									tkCateg.tkDel_par_out.getCategValue(),
									tkCateg.tkDel_bra_enter.getCategValue(),
									ntCateg.ntStatements_main.getCategValue(),
									tkCateg.tkDel_bra_out.getCategValue(),
									tkCateg.tkDel_scolon.getCategValue()}));
			
			else 
				table[ntCateg.ntMain_process.getCategValue() - 51][j]=null;
				
		}
		//--------------------------------------------------------------//
		
		//------------------- Decl = Type “Id”  -------------------//
		
		j=0;
		for (LinkedList<Integer> linkedList : table[ntCateg.ntDecl.getCategValue() - 51]) {
		
		
			if(isFirstType(j))
				table[ntCateg.ntDecl.getCategValue() - 51][j].addAll(CTLL(
					new Integer[]{	ntCateg.ntType.getCategValue(),
									tkCateg.tkId.getCategValue()}));
			
			else 
				table[ntCateg.ntDecl.getCategValue() - 51][j]=null;

		}	
		//--------------------------------------------------------------//
		
		//------------------- Type = “int” | “float” | “char” | “string” | “array” ArrayType   -------------------//
		
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntType.getCategValue() - 51]) {
			
				
				if(j == tkCateg.tkType_int.getCategValue() - 1)
					table[ntCateg.ntType.getCategValue() - 51][j].addAll(CTLL(
						new Integer[]{	tkCateg.tkType_int.getCategValue()}));
				
				else if(j == tkCateg.tkType_bool.getCategValue() - 1)
					table[ntCateg.ntType.getCategValue() - 51][j].addAll(CTLL(
						new Integer[]{	tkCateg.tkType_bool.getCategValue()}));
				
				else if(j == tkCateg.tkType_float.getCategValue() - 1)
					table[ntCateg.ntType.getCategValue() - 51][j].addAll(CTLL(
						new Integer[]{	tkCateg.tkType_float.getCategValue()}));
		 
				else if(j == tkCateg.tkType_char.getCategValue() - 1)
					table[ntCateg.ntType.getCategValue() - 51][j].addAll(CTLL(
						new Integer[]{	tkCateg.tkType_char.getCategValue()}));	
		
				else if(j == tkCateg.tkType_array.getCategValue() - 1)
					table[ntCateg.ntType.getCategValue() - 51][j].addAll(CTLL(
						new Integer[]{	tkCateg.tkType_array.getCategValue(),
										ntCateg.ntType.getCategValue()}));		
		
				else if(j == tkCateg.tkType_string.getCategValue() - 1)
					table[ntCateg.ntType.getCategValue() - 51][j].addAll(CTLL(
						new Integer[]{	tkCateg.tkType_string.getCategValue()}));
				
				else 
					table[ntCateg.ntType.getCategValue() - 51][j]=null;

			}	
		//--------------------------------------------------------------//
			
		//------------------- ArrayType = “:” Type -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntArrayType.getCategValue() - 51]) {
				
				if(j == tkCateg.tkDel_colon.getCategValue() - 1)
					table[ntCateg.ntArrayType.getCategValue() - 51][tkCateg.tkDel_colon.getCategValue() -1].addAll(CTLL(
					new Integer[]{	tkCateg.tkDel_colon.getCategValue(),
									ntCateg.ntStatements_main.getCategValue()}));
				else 
					table[ntCateg.ntArrayType.getCategValue() - 51][j]=null;
			
			}
			
		//--------------------------------------------------------------//
			
		//------------------- Decl_param_list = Decl “,” Decl_param_list | ε -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntDecl_param_list.getCategValue() - 51]) {
			
			
				if(isFirstType(j))
					table[ntCateg.ntDecl_param_list.getCategValue() - 51][j].addAll(CTLL(
						new Integer[]{	ntCateg.ntDecl.getCategValue(),
										tkCateg.tkDel_comma.getCategValue(),
										ntCateg.ntDecl_param_list.getCategValue()}));
				
				else if(j == tkCateg.tkDel_bra_out.getCategValue() - 1)
					table[ntCateg.ntDecl_param_list.getCategValue() - 51][j].addAll(CTLL(
						new Integer[]{}));
				
				else 
					table[ntCateg.ntDecl_param_list.getCategValue() - 51][j]=null;

			}	
		//--------------------------------------------------------------//
			
		//------------------- Statements_return = Statement “;” Statements_return | “return” Exp_log “;” | ε  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntStatements_return.getCategValue() - 51]) {
			
			
				if( isFirstType(j) || )
					table[ntCateg.ntStatements_return.getCategValue() - 51][j].addAll(CTLL(
						new Integer[]{	ntCateg.ntStatement.getCategValue(),
										tkCateg.tkDel_scolon.getCategValue(),
										ntCateg.ntStatements_return.getCategValue()}));

				else if(j == tkCateg.tk_return.getCategValue() - 1)
					table[ntCateg.ntStatements_return.getCategValue() - 51][j].addAll(CTLL(
						new Integer[]{	tkCateg.tk_return.getCategValue(),
										ntCateg.ntExp_log.getCategValue(),
										tkCateg.tkDel_scolon.getCategValue()}));
				
				else if(j == tkCateg.tkDel_bra_out.getCategValue() - 1)
					table[ntCateg.ntStatements_return.getCategValue() - 51][j].addAll(CTLL(
						new Integer[]{}));
				
				else 
					table[ntCateg.ntStatements_return.getCategValue() - 51][j]=null;

			}	
		//--------------------------------------------------------------//
		
	}
	
	private boolean isFirstType(Integer j){
		return (j == tkCateg.tkType_int.getCategValue() - 1 	||
				j == tkCateg.tkType_bool.getCategValue() - 1	||
				j == tkCateg.tkType_float.getCategValue() - 1	||
				j == tkCateg.tkType_char.getCategValue() - 1	||
				j == tkCateg.tkType_string.getCategValue() - 1	||
				j == tkCateg.tkType_array.getCategValue() - 1);
	}
	private boolean isFirstExp_value_aritm(Integer j){
		return (j == tkCateg.tkLit_int.getCategValue() - 1 	||
				j == tkCateg.tkLit_bool.getCategValue() - 1	||
				j == tkCateg.tkLit_float.getCategValue() - 1	||
				j == tkCateg.tkLit_char.getCategValue() - 1	||
				j == tkCateg.tkLit_string.getCategValue() - 1||
				j == tkCateg.tkId.getCategValue() - 1);
	}
	private boolean isFirstExp_aritm4(Integer j){
		return (isFirstExp_value_aritm(j) || j == tkCateg.tkDel_par_enter.getCategValue());
	}
	private boolean isFirstExp_aritm3(Integer j){
		return (j == isFirstExp_aritm4(j) || j == tkCateg.tkOpr_sum.getCategValue());
	}
	private boolean isFirstStatment_return(Integer j){
		return (j == 
	}
	private boolean isFirstStatment_return(Integer j){
		return (j == 
	}
	
	private boolean isFirstStatment_return(Integer j){
		return (j == 
	}
	// CTLL = Convert To LinkedList
	private LinkedList<Integer> CTLL(Integer production[]){
		
		return (LinkedList)Arrays.asList(production);
		
	}
	
	public Integer Query(Integer NT, Integer T){
		NT = NT - 51;
		T = T -1;
		
		
	}

}
