package lexical;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String [] args) {
		String code = "";
		Analyzer anal;
		Token tk;

		// The name of the file to open.
		String fileName = "src/fibonacci.meg";
		// This will reference one line at a time
		String line = null;

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = 
					new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = 
					new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				code = code + line;
			}   

			// Always close files.
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

		anal = new Analyzer(code);
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