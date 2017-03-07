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

	private List<String> linesList;
	private String filePath;
	private final char LINE_BREAK = '\n';
	
	public Analyzer(String filePath) {
		linesList = new ArrayList<>();
		this.filePath = filePath;
	}
	
	public void readFile() {

		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader(filePath));

			String brLine = br.readLine();

			while (brLine != null) {
				linesList.add(brLine);
				brLine = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
