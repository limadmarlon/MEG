package lexical;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class lexicalTable {

	public static Map<String, tkCateg> lexemMap = new HashMap<>();
	public static Map<String, tkCateg> delimitadorMap = new HashMap<>();
	public static List symbolList = new ArrayList<>();

	static{
		//operadores
		lexemMap.put("+", tkCateg.tkOpr_sum);
		lexemMap.put("-", tkCateg.tkOpr_sum);
		lexemMap.put("*", tkCateg.tkOpr_mul);
		lexemMap.put("/", tkCateg.tkOpr_mul);


		lexemMap.put("<", tkCateg.tkOpr_r);
		lexemMap.put(">", tkCateg.tkOpr_r);
		lexemMap.put("<=", tkCateg.tkOpr_r);
		lexemMap.put(">=", tkCateg.tkOpr_r);
		lexemMap.put("==", tkCateg.tkOpr_r);
		lexemMap.put("!", tkCateg.tkOpr_neg);

		lexemMap.put("=", tkCateg.tkOpr_att);
		lexemMap.put("++", tkCateg.tkOpr_concat);
		
		//Indexação
		
		lexemMap.put("[", tkCateg.tkOpr_index_enter);
		lexemMap.put("]", tkCateg.tkOpr_index_out);
		
		// Delimitadores

		lexemMap.put("(", tkCateg.tkDel_par_enter);
		lexemMap.put(")", tkCateg.tkDel_par_out);
		
		lexemMap.put("{", tkCateg.tkDel_bra_enter);
		lexemMap.put("}", tkCateg.tkDel_bra_out);
		
		lexemMap.put("/**", tkCateg.tkDel_comB_enter);
		lexemMap.put("/**", tkCateg.tkDel_comB_out);
		lexemMap.put("//", tkCateg.tkDel_comL);
		
		//terminador
		lexemMap.put(";", tkCateg.tkDel_scolon);
		
		lexemMap.put(":", tkCateg.tkDel_colon);
		lexemMap.put(".", tkCateg.tkDel_dot);
		lexemMap.put(",", tkCateg.tkDel_comma);
		lexemMap.put("\"", tkCateg.tkDel_quoteS);
		lexemMap.put("\"", tkCateg.tkDel_quoteD);
		
		//Palavras reservadas
		lexemMap.put("int", tkCateg.tkType_int);
		lexemMap.put("char", tkCateg.tkType_char);
		lexemMap.put("string", tkCateg.tkType_string);
		lexemMap.put("bool", tkCateg.tkType_bool);
		
		lexemMap.put("if", tkCateg.tk_if);
		lexemMap.put("else", tkCateg.tk_else);
		lexemMap.put("while", tkCateg.tk_while);
		lexemMap.put("do", tkCateg.tk_do);
		lexemMap.put("for", tkCateg.tk_for);
		lexemMap.put("end", tkCateg.tk_end);
		
		lexemMap.put("then", tkCateg.tk_then);
		lexemMap.put("return", tkCateg.tk_return);
		lexemMap.put("input", tkCateg.tk_in);
		lexemMap.put("output", tkCateg.tk_out);
		
		
	}
}
