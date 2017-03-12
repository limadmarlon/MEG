package lexical;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String [] args) {
		String code = "";
		Analyzer anal;
		String result;

		// The name of the file to open.
		String fileName = "src/temp.txt";
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
		result = anal.nextToken().getValue();
		Token tk = anal.nextToken();
		for(int i = 0; i < code.length(); i++){
			//result = result + anal.nextToken().getValue();
			
			tk = anal.nextToken();
			
		}        
		

	}

}