package Main;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import lexical.LexAnalyzer;
import lexical.Token;
import lexical.tkCateg;

public class Main {
	public static void main(String [] args) {
		String code = "";
		LexAnalyzer anal;
		Token tk;

		String fileName = "src/fibonacci.meg";
		String line = null;

		try {
			FileReader fileReader = 
					new FileReader(fileName);
			BufferedReader bufferedReader = 
					new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				code = code + line;
			}   
			bufferedReader.close();         
		}
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							fileName + "'");                
		}
		catch(IOException ex) {
			System.out.println(
					"Error reading file '" 
							+ fileName + "'");               
		}

		anal = new LexAnalyzer(code);
		tk = anal.nextToken();
		System.out.println(tk.toString());

		for(int i = 0; i < code.length(); i++){
			tk = anal.nextToken();
			if(tk.getCategory() != tkCateg.tk_EOF){
				System.out.println(tk.toString());
			}
		}        
	}
}