package sintatical;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import lexical.tkCateg;

public class ParserTable {
	
	private LinkedList<Integer>[][] table;


	@SuppressWarnings({ "unused", "unchecked" })
	public ParserTable() {
		super();
		table = new LinkedList[60][50];
		for (LinkedList<Integer>[] linkedLists : table) {
			for (LinkedList<Integer> linkedList : linkedLists) {
				linkedList = new LinkedList<>();
			}
		}
		
		//------------------- Produção -------------------//
		//------------------- Code = Decl_Main Coder -------------------//
		
		int j=0;
		for (LinkedList<Integer> linkedList : table[ntCateg.ntCode.getCategValue() - 51]) {
			
			if(isFirst_Type(j))			
				table[ntCateg.ntCode.getCategValue() - 51][j] = CTLL(
					new Integer[]{	ntCateg.ntDecl_Main.getCategValue(),
									ntCateg.ntCoder.getCategValue()});
			
			else table[ntCateg.ntCode.getCategValue() - 51][j]=null;
			
			j++;
		}
		
		//--------------------------------------------------------------//
		
		//------------------- Coder= “;” Decl_Main Coder | ε -------------------//
		
		j=0;
		for (LinkedList<Integer> linkedList : table[ntCateg.ntCoder.getCategValue() - 51]) {
		
			if(j == tkCateg.tkDel_scolon.getCategValue() -1) 	
				table[ntCateg.ntCoder.getCategValue() - 51][j] = CTLL(
					new Integer[]{	tkCateg.tkDel_scolon.getCategValue(),
									ntCateg.ntDecl_Main.getCategValue(),
									ntCateg.ntCoder.getCategValue()});
			
			else if(j == tkCateg.tk_EOF.getCategValue() -1) 	
				table[ntCateg.ntCoder.getCategValue() - 51][j] = CTLL(
					new Integer[]{});
			
			else 
				table[ntCateg.ntCoder.getCategValue() - 51][j]=null;
			
			j++;
		
		}
		
		//--------------------------------------------------------------//
		
		//------------------- Decl_Main = Type Main_function -------------------//
		
		j=0;
		for (LinkedList<Integer> linkedList : table[ntCateg.ntDecl_Main.getCategValue() - 51]) {
			
			if(isFirst_Type(j))			
				table[ntCateg.ntDecl_Main.getCategValue() - 51][j] = CTLL(
					new Integer[]{	ntCateg.ntType.getCategValue(),
									ntCateg.ntMain_function.getCategValue()});
			
			else table[ntCateg.ntDecl_Main.getCategValue() - 51][j]=null;
			
			j++;
		}
		//--------------------------------------------------------------//
		
		//------------------- Main_function = “Id” “(” Decl_param_list “)” “{” Statements_return “}” Main_function | “main” Main_process -------------------//
		
		j=0;
		for (LinkedList<Integer> linkedList : table[ntCateg.ntMain_function.getCategValue() - 51]) {
		
			if(j == tkCateg.tkId.getCategValue() -1) 
				table[ntCateg.ntMain_function.getCategValue() - 51][j] = CTLL(
					new Integer[]{	tkCateg.tkId.getCategValue(),
									tkCateg.tkDel_par_enter.getCategValue(),
									ntCateg.ntDecl_param_list.getCategValue(),
									tkCateg.tkDel_par_out.getCategValue(),
									tkCateg.tkDel_bra_enter.getCategValue(),
									ntCateg.ntStatements_return.getCategValue(),
									tkCateg.tkDel_bra_out.getCategValue(),
									ntCateg.ntMain_function.getCategValue()});
			
			else if(j == tkCateg.tkMain.getCategValue() -1)
				table[ntCateg.ntMain_function.getCategValue() - 51][j] = CTLL(
					new Integer[]{	tkCateg.tkMain.getCategValue(),
									ntCateg.ntMain_process.getCategValue()});
			
			else 
				table[ntCateg.ntMain_function.getCategValue() - 51][j]=null;
			
			j++;
			
		}
		//--------------------------------------------------------------//
		
		
		//------------------- Main_process = “(” “)” “{” Statements_main “}” “;” -------------------//
		
		j=0;
		for (LinkedList<Integer> linkedList : table[ntCateg.ntMain_process.getCategValue() - 51]) {
		
			if(j == tkCateg.tkDel_par_enter.getCategValue() - 1)
				table[ntCateg.ntMain_process.getCategValue() - 51][j] = CTLL(
					new Integer[]{	tkCateg.tkDel_par_enter.getCategValue(),
									tkCateg.tkDel_par_out.getCategValue(),
									tkCateg.tkDel_bra_enter.getCategValue(),
									ntCateg.ntStatements_return.getCategValue(),
									tkCateg.tkDel_bra_out.getCategValue(),
									tkCateg.tkDel_scolon.getCategValue()});
			
			else 
				table[ntCateg.ntMain_process.getCategValue() - 51][j]=null;
				
			j++;
		}
		//--------------------------------------------------------------//
		
		//------------------- Decl = Type “Id”  -------------------//
		
		j=0;
		for (LinkedList<Integer> linkedList : table[ntCateg.ntDecl.getCategValue() - 51]) {
		
		
			if(isFirst_Type(j))
				table[ntCateg.ntDecl.getCategValue() - 51][j] = CTLL(
					new Integer[]{	ntCateg.ntType.getCategValue(),
									tkCateg.tkId.getCategValue()});
			
			else 
				table[ntCateg.ntDecl.getCategValue() - 51][j]=null;
			
			j++;
		}	
		//--------------------------------------------------------------//
		
		//------------------- Type = “int” | “float” | “char” | “string” | “array” ArrayType   -------------------//
		
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntType.getCategValue() - 51]) {
			
				
				if(j == tkCateg.tkType_int.getCategValue() - 1)
					table[ntCateg.ntType.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkType_int.getCategValue()});
				
				else if(j == tkCateg.tkType_bool.getCategValue() - 1)
					table[ntCateg.ntType.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkType_bool.getCategValue()});
				
				else if(j == tkCateg.tkType_float.getCategValue() - 1)
					table[ntCateg.ntType.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkType_float.getCategValue()});
		 
				else if(j == tkCateg.tkType_char.getCategValue() - 1)
					table[ntCateg.ntType.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkType_char.getCategValue()});	
		
				else if(j == tkCateg.tkType_array.getCategValue() - 1)
					table[ntCateg.ntType.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkType_array.getCategValue(),
										ntCateg.ntType.getCategValue()});		
		
				else if(j == tkCateg.tkType_string.getCategValue() - 1)
					table[ntCateg.ntType.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkType_string.getCategValue()});
				
				else 
					table[ntCateg.ntType.getCategValue() - 51][j]=null;
				
				j++;
			}	
		//--------------------------------------------------------------//
			
		//------------------- ArrayType = “:” Type -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntArrayType.getCategValue() - 51]) {
				
				if(j == tkCateg.tkDel_colon.getCategValue() - 1)
					table[ntCateg.ntArrayType.getCategValue() - 51][tkCateg.tkDel_colon.getCategValue() -1] = CTLL(
					new Integer[]{	tkCateg.tkDel_colon.getCategValue(),
									ntCateg.ntStatements_return.getCategValue()});
				else 
					table[ntCateg.ntArrayType.getCategValue() - 51][j]=null;
			
				j++;
			}
			
		//--------------------------------------------------------------//
			
		//------------------- Decl_param_list = Decl “,” Decl_param_list | ε -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntDecl_param_list.getCategValue() - 51]) {
			
			
				if(isFirst_Type(j))
					table[ntCateg.ntDecl_param_list.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntDecl.getCategValue(),
										tkCateg.tkDel_comma.getCategValue(),
										ntCateg.ntDecl_param_list.getCategValue()});
				
				else if(j == tkCateg.tkDel_bra_out.getCategValue() - 1)
					table[ntCateg.ntDecl_param_list.getCategValue() - 51][j] = CTLL(
						new Integer[]{});
				
				else 
					table[ntCateg.ntDecl_param_list.getCategValue() - 51][j]=null;
				j++;
			}	
		//--------------------------------------------------------------//
			
		//------------------- Statements_return = Statement “;” Statements_return | “return” Exp_log “;”  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntStatements_return.getCategValue() - 51]) {
			
			
				if( isFirst_Statment(j) )
					table[ntCateg.ntStatements_return.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntStatement.getCategValue(),
										tkCateg.tkDel_scolon.getCategValue(),
										ntCateg.ntStatements_return.getCategValue()});

				else if(j == tkCateg.tk_return.getCategValue() - 1)
					table[ntCateg.ntStatements_return.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tk_return.getCategValue(),
										ntCateg.ntExp_Start.getCategValue(),
										tkCateg.tkDel_scolon.getCategValue()});
				
				else 
					table[ntCateg.ntStatements_return.getCategValue() - 51][j]=null;

			j++;}	
		//--------------------------------------------------------------//
			
		//------------------- Statements_return_op = Statement “;” Statements_return_op | “return” Exp_log “;” | ε  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntStatements_return_op.getCategValue() - 51]) {
			
			
				if( isFirst_Statment(j) )
					table[ntCateg.ntStatements_return_op.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntStatement.getCategValue(),
										tkCateg.tkDel_scolon.getCategValue(),
										ntCateg.ntStatements_return_op.getCategValue()});

				else if(j == tkCateg.tk_return.getCategValue() - 1)
					table[ntCateg.ntStatements_return_op.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tk_return.getCategValue(),
										ntCateg.ntExp_Start.getCategValue(),
										tkCateg.tkDel_scolon.getCategValue()});
				
				else if(j == tkCateg.tkDel_bra_out.getCategValue() - 1)
					table[ntCateg.ntStatements_return_op.getCategValue() - 51][j] = CTLL(
						new Integer[]{});
				
				else 
					table[ntCateg.ntStatements_return_op.getCategValue() - 51][j]=null;

			j++;}	
		//--------------------------------------------------------------//
			
		//------------------- Exp_start = “id” Id_asfirst | NotId_asFirst  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntExp_Start.getCategValue() - 51]) {
			
			
				if( j == tkCateg.tkId.getCategValue() -1 )
					table[ntCateg.ntExp_Start.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkId.getCategValue(),
										ntCateg.ntId_asfirst.getCategValue()});

				else if(isFirst_NotIdAsFirst(j))
					table[ntCateg.ntExp_Start.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntNotId_asfirst.getCategValue()});
				
				else 
					table[ntCateg.ntExp_Start.getCategValue() - 51][j]=null;

			j++;}	
		//--------------------------------------------------------------//
			
		//------------------- Id_asfirst = = ATT | Differ2 | ( “&” | “|” ) Exp_log2 Exp_logr | opr_rel Exp_aritm | ( “+” | “-” ) Exp_aritm2 Exp_aritmr | Exp_aritm2r  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntId_asfirst.getCategValue() - 51]) {
			
			
				if( j == tkCateg.tkOpr_att.getCategValue() -1 )
					table[ntCateg.ntId_asfirst.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkOpr_att.getCategValue(),
										ntCateg.ntATT.getCategValue()});

				else if(isFirst_Differ2(j))
					table[ntCateg.ntId_asfirst.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntDiffer2.getCategValue()});
				
				else if(j == tkCateg.tkOpr_log.getCategValue() - 1)
					table[ntCateg.ntId_asfirst.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkOpr_log.getCategValue(),
										ntCateg.ntExp_log2.getCategValue(),
										ntCateg.ntExp_logr.getCategValue()});
				else if(j == tkCateg.tkOpr_r.getCategValue() - 1)
					table[ntCateg.ntId_asfirst.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkOpr_r.getCategValue(),
										ntCateg.ntExp_aritm.getCategValue()});
				else if(j == tkCateg.tkOpr_sum.getCategValue() - 1)
					table[ntCateg.ntId_asfirst.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkOpr_sum.getCategValue(),
										ntCateg.ntExp_aritm2.getCategValue(),
										ntCateg.ntExp_aritmr.getCategValue()});
				else if(j == tkCateg.tkOpr_mul.getCategValue() - 1)
					table[ntCateg.ntId_asfirst.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntExp_aritm2r.getCategValue()});
				
				else 
					table[ntCateg.ntId_asfirst.getCategValue() - 51][j]=null;

			j++;}	
		//--------------------------------------------------------------//
			
		//------------------- NotId_asFirst = Not_log_value Exp_logr | Una_aritm_value Exp_rel_aritm  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntNotId_asfirst.getCategValue() - 51]) {
			
			
				if( isFirst_Not_log_value(j) )
					table[ntCateg.ntNotId_asfirst.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntNot_log_value.getCategValue(),
										ntCateg.ntExp_logr.getCategValue()});

				else if(isFirst_Una_aritm_value(j))
					table[ntCateg.ntNotId_asfirst.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntUna_aritm_value.getCategValue(),
										ntCateg.ntExp_rel_aritm.getCategValue()});
				
				else 
					table[ntCateg.ntNotId_asfirst.getCategValue() - 51][j]=null;

			j++;}	
		//--------------------------------------------------------------//
			
		//------------------- Exp_rel_aritm = ( “==” | “=>” | “>” | “<” | “<=” ) Exp_aritm | ( “+” | “-” ) Exp_aritm2 Exp_aritmr | Exp_aritm2r  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntExp_rel_aritm.getCategValue() - 51]) {
			
			
				if( j == tkCateg.tkOpr_r.getCategValue() - 1)
					table[ntCateg.ntExp_rel_aritm.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkOpr_r.getCategValue(),
										ntCateg.ntExp_aritm.getCategValue()});

				else if(j == tkCateg.tkOpr_sum.getCategValue() - 1)
					table[ntCateg.ntExp_rel_aritm.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkOpr_sum.getCategValue(),
										ntCateg.ntExp_aritm2.getCategValue(),
										ntCateg.ntExp_aritmr.getCategValue()});
				
				else if(j == tkCateg.tkOpr_mul.getCategValue() - 1)
					table[ntCateg.ntExp_rel_aritm.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntExp_aritm2r.getCategValue()});
				
				else 
					table[ntCateg.ntExp_rel_aritm.getCategValue() - 51][j]=null;

			j++;}	
		//--------------------------------------------------------------//
			
		//------------------- Not_log_value = “!” Log_noId | Log_noId   -------------------//
		//------------------- Log_noId = “true” | “false”   -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntNot_log_value.getCategValue() - 51]) {
			
			
				if( j == tkCateg.tkOpr_neg.getCategValue() - 1)
					table[ntCateg.ntNot_log_value.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkOpr_neg.getCategValue(),
									tkCateg.tkLit_bool.getCategValue()});

				else if(j == tkCateg.tkLit_bool.getCategValue() - 1)
					table[ntCateg.ntNot_log_value.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkLit_bool.getCategValue()});
				
				else 
					table[ntCateg.ntNot_log_value.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- Una_aritm_value = ( “+” | “-” ) Par_aritm_value | Par_aritm_value   -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntUna_aritm_value.getCategValue() - 51]) {
			
			
				if( j == tkCateg.tkOpr_sum.getCategValue() - 1)
					table[ntCateg.ntUna_aritm_value.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkOpr_sum.getCategValue(),
									ntCateg.ntPar_aritm_value.getCategValue()});

				else if(isFirst_Par_aritm_value(j))
					table[ntCateg.ntUna_aritm_value.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntPar_aritm_value.getCategValue()});
				
				else 
					table[ntCateg.ntUna_aritm_value.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- Par_aritm_value = “(” Exp_Paren_Cast | Aritm_no_id -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntPar_aritm_value.getCategValue() - 51]) {
			
			
				if( j == tkCateg.tkDel_par_enter.getCategValue() - 1)
					table[ntCateg.ntPar_aritm_value.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkDel_par_enter.getCategValue(),
										ntCateg.ntExp_Paren_Cast.getCategValue()});

				else if(isFirst_Aritm_NoId(j))
					table[ntCateg.ntPar_aritm_value.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntAritm_no_id.getCategValue()});
				
				else 
					table[ntCateg.ntPar_aritm_value.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- Aritm_no_id = “lit_string” CC | “lit_float” | “lit_int” | “lit_char” -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntAritm_no_id.getCategValue() - 51]) {
			
			
				if( j == tkCateg.tkLit_string.getCategValue() - 1)
					table[ntCateg.ntAritm_no_id.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkLit_string.getCategValue(),
										ntCateg.ntCC.getCategValue()});

				else if(j == tkCateg.tkLit_float.getCategValue() - 1)
					table[ntCateg.ntAritm_no_id.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkLit_float.getCategValue()});
				
				if( j == tkCateg.tkLit_int.getCategValue() - 1)
					table[ntCateg.ntAritm_no_id.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkLit_int.getCategValue()});

				else if(j == tkCateg.tkLit_char.getCategValue() - 1)
					table[ntCateg.ntAritm_no_id.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkLit_char.getCategValue()});
				
				else 
					table[ntCateg.ntAritm_no_id.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- ATT = “input” | Exp_log -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntATT.getCategValue() - 51]) {
			
			
				if( j == tkCateg.tk_in.getCategValue() - 1)
					table[ntCateg.ntATT.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkLit_string.getCategValue(),
										ntCateg.ntCC.getCategValue()});

				else if(isFirst_Exp_log(j))
					table[ntCateg.ntATT.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntExp_log.getCategValue()});
				
				else 
					table[ntCateg.ntAritm_no_id.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- Exp_log = Exp_log2 Exp_logr  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntExp_log.getCategValue() - 51]) {
			
			
				if( isFirst_Exp_log(j))
					table[ntCateg.ntExp_log.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntExp_log2.getCategValue(),
										ntCateg.ntExp_logr.getCategValue()});
				
				else 
					table[ntCateg.ntAritm_no_id.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
		
		//------------------- Exp_logr = ( “&” | “|” ) Exp_log2 Exp_logr | ε  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntExp_logr.getCategValue() - 51]) {
			
			
				if( j == tkCateg.tkOpr_log.getCategValue() - 1)
					table[ntCateg.ntExp_logr.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkOpr_log.getCategValue(),
										ntCateg.ntExp_log2.getCategValue(),
										ntCateg.ntExp_logr.getCategValue()});

				else if(isFollow_Exp_logr(j))
					table[ntCateg.ntExp_logr.getCategValue() - 51][j] = CTLL(
						new Integer[]{});
				
				else 
					table[ntCateg.ntAritm_no_id.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- Exp_log2 = “!” value_log | value_log    -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntExp_log2.getCategValue() - 51]) {
			
			
				if( j == tkCateg.tkOpr_neg.getCategValue() - 1)
					table[ntCateg.ntExp_log2.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkOpr_neg.getCategValue(),
									ntCateg.ntvalue_log.getCategValue()});

				else if(j == tkCateg.tkLit_bool.getCategValue() - 1 || isFirst_Exp_aritm(j))
					table[ntCateg.ntExp_log2.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntvalue_log.getCategValue()});
				
				else 
					table[ntCateg.ntExp_log2.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- value_log = LogNoId | Exp_rel    -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntvalue_log.getCategValue() - 51]) {
			
			
				if( isFirst_Exp_aritm(j))
					table[ntCateg.ntvalue_log.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntExp_rel.getCategValue()});

				else if(j == tkCateg.tkLit_bool.getCategValue() - 1)
					table[ntCateg.ntvalue_log.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkLit_bool.getCategValue()});
				
				else 
					table[ntCateg.ntExp_log2.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- Exp_rel = Exp_aritm Exp_relr     -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntExp_rel.getCategValue() - 51]) {
			
			
				if( isFirst_Exp_aritm(j))
					table[ntCateg.ntExp_rel.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntExp_aritm.getCategValue(),
										ntCateg.ntExp_relr.getCategValue()});
				
				else 
					table[ntCateg.ntExp_rel.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- Exp_relr = ( “==” | “=>” | “>” | “<” | “<=” ) Exp_aritm | ε     -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntExp_relr.getCategValue() - 51]) {
			
			
				if( j == tkCateg.tkOpr_r.getCategValue())
					table[ntCateg.ntExp_relr.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkOpr_r.getCategValue(),
										ntCateg.ntExp_aritm.getCategValue()});
				
				else if( isFollow_Exp_relr(j))
					table[ntCateg.ntExp_relr.getCategValue() - 51][j] = CTLL(
						new Integer[]{	});
				
				else 
					table[ntCateg.ntExp_relr.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- Exp_aritm = Exp_aritm2 Exp_aritmr   -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntExp_aritm.getCategValue() - 51]) {
			
			
				if( isFirst_Exp_aritm(j))
					table[ntCateg.ntExp_aritm.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntExp_aritm2.getCategValue(),
										ntCateg.ntExp_aritmr.getCategValue()});
				
				else 
					table[ntCateg.ntExp_aritm.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
		
		//------------------- Exp_aritmr = ( “+” | “-” ) Exp_aritm2 Exp_aritmr | ε   -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntExp_aritmr.getCategValue() - 51]) {
			
			
				if( j == tkCateg.tkOpr_log.getCategValue() - 1)
					table[ntCateg.ntExp_aritmr.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkOpr_sum.getCategValue(),
										ntCateg.ntExp_aritm2.getCategValue(),
										ntCateg.ntExp_aritmr.getCategValue()});

				else if(isFollow_Exp_aritmr(j))
					table[ntCateg.ntExp_aritmr.getCategValue() - 51][j] = CTLL(
						new Integer[]{});
				
				else 
					table[ntCateg.ntExp_aritmr.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
		
		//------------------- Exp_aritm2 = Exp_aritm3 Exp_aritm2r  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntExp_aritm2.getCategValue() - 51]) {
			
			
				if( isFirst_Exp_aritm(j) )
					table[ntCateg.ntExp_aritm2.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntExp_aritm3.getCategValue(),
										ntCateg.ntExp_aritm2r.getCategValue()});
				
				else 
					table[ntCateg.ntExp_aritm2.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
		
		//------------------- Exp_aritm2r = ( “*” | “/” ) Exp_aritm3 Exp_aritm2r | ε   -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntExp_aritm2r.getCategValue() - 51]) {
			
			
				if( j == tkCateg.tkOpr_mul.getCategValue() - 1)
					table[ntCateg.ntExp_aritm2r.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkOpr_mul.getCategValue(),
										ntCateg.ntExp_aritm3.getCategValue(),
										ntCateg.ntExp_aritm2r.getCategValue()});

				else if(isFollow_Exp_aritm2r(j))
					table[ntCateg.ntExp_aritm2r.getCategValue() - 51][j] = CTLL(
						new Integer[]{});
				
				else 
					table[ntCateg.ntExp_aritm2r.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- Exp_aritm3 = ( “+” | “-” ) Exp_aritm4 | Exp_aritm4  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntExp_aritm3.getCategValue() - 51]) {
			
			
				if( j == tkCateg.tkOpr_sum.getCategValue() - 1)
					table[ntCateg.ntExp_aritm3.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkOpr_sum.getCategValue(),
										ntCateg.ntExp_aritm4.getCategValue()});

				else if(isFirst_Par_aritm_value(j) || j == tkCateg.tkId.getCategValue() -1)
					table[ntCateg.ntExp_aritm3.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntExp_aritm4.getCategValue()});
				
				else 
					table[ntCateg.ntExp_aritm3.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- Exp_aritm4 = “(” Exp_Paren_Cast | value_aritm  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntExp_aritm4.getCategValue() - 51]) {
			
			
				if( j == tkCateg.tkDel_par_enter.getCategValue() - 1)
					table[ntCateg.ntExp_aritm4.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkDel_par_enter.getCategValue(),
										ntCateg.ntExp_Paren_Cast.getCategValue()});

				else if(isFirst_Aritm_NoId(j) || j == tkCateg.tkId.getCategValue() - 1)
					table[ntCateg.ntExp_aritm4.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntvalue_aritm.getCategValue()});
				
				else 
					table[ntCateg.ntExp_aritm4.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- Exp_Paren_Cast =  Cast | Exp_log “)”  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntExp_Paren_Cast.getCategValue() - 51]) {
			
			
				if( j == tkCateg.tkOpr_concat.getCategValue() - 1)
					table[ntCateg.ntExp_Paren_Cast.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntCast.getCategValue()});

				else if(isFirst_Exp_log(j))
					table[ntCateg.ntExp_Paren_Cast.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntExp_log.getCategValue(),
										tkCateg.tkDel_par_out.getCategValue()});
				
				else 
					table[ntCateg.ntExp_Paren_Cast.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- value_aritm = “id” Differ2 | Aritm_no_id   -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntvalue_aritm.getCategValue() - 51]) {
			
			
				if( j == tkCateg.tkId.getCategValue() - 1)
					table[ntCateg.ntvalue_aritm.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkId.getCategValue(),
										ntCateg.ntDiffer2.getCategValue()});

				else if(isFirst_Aritm_NoId(j))
					table[ntCateg.ntvalue_aritm.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntAritm_no_id.getCategValue()});
				
				else 
					table[ntCateg.ntvalue_aritm.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
		
		//------------------- Differ2 = “[” Index | Concat | FunCall    -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntDiffer2.getCategValue() - 51]) {
			
			
				if( j == tkCateg.tkOpr_index_enter.getCategValue() - 1)
					table[ntCateg.ntDiffer2.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkOpr_index_enter.getCategValue(),
										ntCateg.ntIndex.getCategValue()});

				else if(j == tkCateg.tkOpr_concat.getCategValue() - 1)
					table[ntCateg.ntDiffer2.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntConcat.getCategValue()});
				
				else if(j == tkCateg.tkDel_par_enter.getCategValue() - 1)
					table[ntCateg.ntDiffer2.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntFunCall.getCategValue()});
				
				else 
					table[ntCateg.ntDiffer2.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- CC = Concat | ε    -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntConcat.getCategValue() - 51]) {
			
			
				if( j == tkCateg.tkOpr_concat.getCategValue() - 1)
					table[ntCateg.ntConcat.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntConcat.getCategValue()});

				else if(isFollow_Exp_aritm2r(j) || j == tkCateg.tkId.getCategValue() - 1 ||
						j == tkCateg.tkOpr_mul.getCategValue() - 1 || j == tkCateg.tkLit_string.getCategValue() - 1)
					table[ntCateg.ntConcat.getCategValue() - 51][j] = CTLL(
						new Integer[]{});
				
				else 
					table[ntCateg.ntConcat.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- FunCall = “(” FunCallr     -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntFunCall.getCategValue() - 51]) {
			
			
				if( j == tkCateg.tkDel_par_enter.getCategValue() - 1)
					table[ntCateg.ntFunCall.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkDel_par_enter.getCategValue(),
										ntCateg.ntFunCallr.getCategValue()});
				else 
					table[ntCateg.ntFunCall.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- FunCallr = FunCallParam “)” | “)”  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntFunCallr.getCategValue() - 51]) {
			
			
				if( isFirst_Exp_log(j))
					table[ntCateg.ntFunCallr.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntFunCallParam.getCategValue(),
										tkCateg.tkDel_par_out.getCategValue()});
				
				else if( j == tkCateg.tkDel_par_out.getCategValue() - 1)
					table[ntCateg.ntFunCallr.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkDel_par_out.getCategValue()});
				
				else 
					table[ntCateg.ntFunCallr.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- FunCallParam = Exp_log FunCallParamr  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntFunCallParam.getCategValue() - 51]) {
			
			
				if( isFirst_Aritm_NoId(j))
					table[ntCateg.ntFunCallParam.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntExp_log.getCategValue(),
										ntCateg.ntFunCallParamr.getCategValue()});
				
				else 
					table[ntCateg.ntFunCallParam.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- FunCallParamr = “,” Exp_log FunCallParamr | ε  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntFunCallParam.getCategValue() - 51]) {
			
			
				if(j == tkCateg.tkDel_comma.getCategValue() - 1)
					table[ntCateg.ntFunCallParam.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkDel_comma.getCategValue(),
										ntCateg.ntExp_log.getCategValue(),
										ntCateg.ntFunCallParamr.getCategValue()});
				
				else if( j == tkCateg.tkDel_par_out.getCategValue() - 1)
					table[ntCateg.ntFunCallParam.getCategValue() - 51][j] = CTLL(
						new Integer[]{ });
				
				else 
					table[ntCateg.ntFunCallParam.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- Index = Exp_aritm “]” -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntIndex.getCategValue() - 51]) {
			
			
				if(isFirst_Exp_aritm(j))
					table[ntCateg.ntFunCallParam.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntExp_log.getCategValue(),
										tkCateg.tkOpr_index_out.getCategValue()});
				
				else 
					table[ntCateg.ntIndex.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- Cast = Cast_Type “)” CastParam  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntCast.getCategValue() - 51]) {
			
			
				if(isFirst_Exp_aritm(j))
					table[ntCateg.ntCast.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntCast_Type.getCategValue(),
										tkCateg.tkDel_par_out.getCategValue(),
										ntCateg.ntCastParam.getCategValue()});
				
				else 
					table[ntCateg.ntCast.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			//------------------- CastParam = “char” | Exp_aritm4   -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntCastParam.getCategValue() - 51]) {
			
			
				if(isFirst_Exp_aritm(j))
					table[ntCateg.ntCastParam.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntExp_aritm4.getCategValue()});
				else if(j == tkCateg.tkLit_char.getCategValue() -1)
					table[ntCateg.ntCastParam.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkLit_char.getCategValue()});
				
				else 
					table[ntCateg.ntCastParam.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			//------------------- Cast_Type = “int” | “float” | “char” | “string”  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntCast_Type.getCategValue() - 51]) {
			
			
				if( j == tkCateg.tkType_string.getCategValue() - 1)
					table[ntCateg.ntCast_Type.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkType_string.getCategValue()});
				
				else if( j == tkCateg.tkType_char.getCategValue() - 1)
					table[ntCateg.ntCast_Type.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkType_char.getCategValue()});
				
				else if( j == tkCateg.tkType_int.getCategValue() - 1)
					table[ntCateg.ntCast_Type.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkType_int.getCategValue()});
				
				else if( j == tkCateg.tkType_float.getCategValue() - 1)
					table[ntCateg.ntCast_Type.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkType_float.getCategValue()});
				
				else 
					table[ntCateg.ntCast_Type.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- Concat = “++” Concat2  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntConcat.getCategValue() - 51]) {
			
			
				if(j == tkCateg.tkOpr_concat.getCategValue() - 1)
					table[ntCateg.ntConcat.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkOpr_concat.getCategValue(),
										ntCateg.ntConcat2.getCategValue()});
				
				else 
					table[ntCateg.ntConcat.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- Concat2 = “id” | “lit_string” | Cast  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntConcat2.getCategValue() - 51]) {
			
			
				if(j == tkCateg.tkId.getCategValue() - 1)
					table[ntCateg.ntConcat2.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkId.getCategValue()});
				
				else if(j == tkCateg.tkLit_string.getCategValue() - 1)
					table[ntCateg.ntConcat2.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkLit_string.getCategValue()});
				
				else if(isFirst_Exp_aritm(j))
					table[ntCateg.ntConcat2.getCategValue() - 51][j] = CTLL(
						new Integer[]{	ntCateg.ntCast.getCategValue()});
				
				else 
					table[ntCateg.ntConcat.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- Output = “output” OP   -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntOutput.getCategValue() - 51]) {
			
			
				if(j == tkCateg.tk_out.getCategValue() - 1)
					table[ntCateg.ntOutput.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tk_out.getCategValue(),
										ntCateg.ntOP.getCategValue()});
				
				else 
					table[ntCateg.ntConcat.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- OP = “id” Concat OP | “lit_string” Concat OP | ε  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntOP.getCategValue() - 51]) {
			
			
				if(j == tkCateg.tkId.getCategValue() - 1)
					table[ntCateg.ntOP.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkId.getCategValue(),
										ntCateg.ntConcat.getCategValue(),
										ntCateg.ntOP.getCategValue()});
				
				else if(j == tkCateg.tkLit_string.getCategValue() - 1)
					table[ntCateg.ntOP.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tkLit_string.getCategValue(),
										ntCateg.ntConcat.getCategValue(),
										ntCateg.ntOP.getCategValue()});
				
				else if(j == tkCateg.tkDel_scolon.getCategValue() -1)
					table[ntCateg.ntOP.getCategValue() - 51][j] = CTLL(
						new Integer[]{});
				
				else 
					table[ntCateg.ntOP.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
//------------------- IF_THEN = “if” Exp_log “then” Statements_return_op ELSE   -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntIF_THEN.getCategValue() - 51]) {
			
			
				if(j == tkCateg.tk_if.getCategValue() - 1)
					table[ntCateg.ntIF_THEN.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tk_if.getCategValue(),
										ntCateg.ntExp_log.getCategValue(),
										tkCateg.tk_then.getCategValue(),
										ntCateg.ntStatements_return_op.getCategValue(),
										ntCateg.ntELSE.getCategValue()});
				
				else 
					table[ntCateg.ntIF_THEN.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- ELSE = “end” | “else” Statements_return_op “end”  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntELSE.getCategValue() - 51]) {
			
			
				if(j == tkCateg.tk_end.getCategValue() - 1)
					table[ntCateg.ntELSE.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tk_end.getCategValue()});
				
				else if(j == tkCateg.tk_else.getCategValue() - 1)
					table[ntCateg.ntELSE.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tk_else.getCategValue(),
										ntCateg.ntStatements_return_op.getCategValue(),
										tkCateg.tk_end.getCategValue()});
				else 
					table[ntCateg.ntELSE.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
		//------------------- WHILE = “while” Exp_log "then" Statements_return_op “end”  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntWHILE.getCategValue() - 51]) {
			
			
				if(j == tkCateg.tk_while.getCategValue() - 1)
					table[ntCateg.ntWHILE.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tk_while.getCategValue(),
										ntCateg.ntExp_log.getCategValue(),
										tkCateg.tk_then.getCategValue(),
										ntCateg.ntStatements_return_op.getCategValue(),
										tkCateg.tk_end.getCategValue()});
				
				else 
					table[ntCateg.ntWHILE.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
			
//------------------- FOR = “for” Exp_aritm “:” Exp_aritm “then” Statements_return_op “end”  -------------------//
			
			j=0;
			for (LinkedList<Integer> linkedList : table[ntCateg.ntFOR.getCategValue() - 51]) {
			
			
				if(j == tkCateg.tk_for.getCategValue() - 1)
					table[ntCateg.ntFOR.getCategValue() - 51][j] = CTLL(
						new Integer[]{	tkCateg.tk_for.getCategValue(),
										ntCateg.ntExp_aritm.getCategValue(),
										tkCateg.tkDel_colon.getCategValue(),
										ntCateg.ntExp_aritm.getCategValue(),
										tkCateg.tk_then.getCategValue(),
										ntCateg.ntStatements_return_op.getCategValue(),
										tkCateg.tk_end.getCategValue()});
				else 
					table[ntCateg.ntFOR.getCategValue() - 51][j]=null;

			j++;}	
			
		//--------------------------------------------------------------//
		
	}
	
	private boolean isFirst_Statment(Integer j){
		return (j == tkCateg.tkId.getCategValue() -1 ||
				isFirst_NotIdAsFirst(j) ||
				isFirst_Type(j) || 
				j == tkCateg.tk_out.getCategValue() - 1 ||
				j == tkCateg.tk_while.getCategValue() -1||
				j == tkCateg.tk_for.getCategValue() -1||
				j == tkCateg.tk_if.getCategValue() -1
				);
	}
	private boolean isFirst_Type(Integer j){
		return (j == tkCateg.tkType_int.getCategValue() - 1 	||
				j == tkCateg.tkType_bool.getCategValue() - 1	||
				j == tkCateg.tkType_float.getCategValue() - 1	||
				j == tkCateg.tkType_char.getCategValue() - 1	||
				j == tkCateg.tkType_string.getCategValue() - 1	||
				j == tkCateg.tkType_array.getCategValue() - 1);
	}
	private boolean isFirst_NotIdAsFirst(Integer j){
		return (isFirst_Not_log_value(j) || isFirst_Una_aritm_value(j));
	}
	private boolean isFirst_Not_log_value(Integer j){
		return (j == tkCateg.tkOpr_neg.getCategValue() - 1||
				j == tkCateg.tkLit_bool.getCategValue() - 1);
	}
	private boolean isFirst_Una_aritm_value(Integer j){
		return (j == tkCateg.tkOpr_sum.getCategValue() - 1 || isFirst_Par_aritm_value(j));
				
	}
	private boolean isFirst_Par_aritm_value(Integer j){
		return (j == tkCateg.tkDel_par_enter.getCategValue() - 1 || isFirst_Aritm_NoId(j));
				
	}
	private boolean isFirst_Aritm_NoId(Integer j){
		return (j == tkCateg.tkLit_int.getCategValue() - 1 	||
				j == tkCateg.tkLit_float.getCategValue() - 1||
				j == tkCateg.tkLit_char.getCategValue() - 1	||
				j == tkCateg.tkLit_string.getCategValue() - 1);
				
	}
	private boolean isFirst_Differ2(Integer j){
		return (j == tkCateg.tkOpr_index_enter.getCategValue() - 1 	||
				j == tkCateg.tkOpr_concat.getCategValue() - 1	||
				j == tkCateg.tkDel_par_enter.getCategValue() - 1);
				
	}
	private boolean isFirst_Exp_log(Integer j){
		return (j == tkCateg.tkOpr_neg.getCategValue() - 1||
				j == tkCateg.tkLit_bool.getCategValue() -1||
				isFirst_Exp_aritm(j));
	}
	private boolean isFirst_Exp_aritm(Integer j){
		return (j == tkCateg.tkId.getCategValue() - 1 ||
				isFirst_Una_aritm_value(j));
	}
	
	private boolean isFollow_Exp_logr(Integer j){

		return (j == tkCateg.tkDel_scolon.getCategValue() - 1 	||
				j == tkCateg.tkDel_par_out.getCategValue() - 1||
				j == tkCateg.tkDel_comma.getCategValue() - 1	||
				j == tkCateg.tk_then.getCategValue() - 1);
	}
	private boolean isFollow_Exp_relr(Integer j){
		return isFollow_Exp_logr(j) || j == tkCateg.tkOpr_log.getCategValue() -1 ;
	}
	private boolean isFollow_Exp_aritmr(Integer j){
		return (isFollow_Exp_relr(j) || 
				j == tkCateg.tkDel_colon.getCategValue() -1 || 
				j == tkCateg.tkOpr_index_out.getCategValue() -1	|| 
				j == tkCateg.tkOpr_r.getCategValue() -1);
	}
	private boolean isFollow_Exp_aritm2r(Integer j){
		return isFollow_Exp_aritmr(j) || j == tkCateg.tkOpr_sum.getCategValue() -1 ;
	}
	// CTLL = Convert To LinkedList
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private LinkedList<Integer> CTLL(Integer production[]){
		
		return  new LinkedList<Integer>(Arrays.asList(production));
		
	}
	
	public LinkedList<Integer> Query(Integer NT, Integer T){
		NT = NT - 51;
		T = T -1;
		
		Iterator<Integer> Element = table[NT][T].descendingIterator();
		
		LinkedList<Integer> production = new LinkedList<>();
		
		for (@SuppressWarnings("unused") Integer integer : table[NT][T]) {
			production.add(Element.next());
		}	
		return production;
		
		
	}


}
