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
		lexemMap.put("-", tkCateg.);
		lexemMap.put("*", tkCateg.tkOpr_mul);
		
	}
}
