package lexical;

public class Token {

	private String value;
	private tkCateg category;
	private int line;
	private int column;
	
	public Token() {
		
		
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public tkCateg getCategory() {
		return category;
	}

	public void setCategory(tkCateg category) {
		this.category = category;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
}
