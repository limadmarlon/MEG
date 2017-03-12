package lexical;

public class Token {

	private String value;
	private tkCateg category;
	private int pos;
	
	public Token(String value, tkCateg category, int line) {
		super();
		this.value = value;
		this.category = category;
		this.pos = line;
	}
	
	@Override
	public String toString() {
		return "<" + pos +"> " + category + " = '" + value + "'";
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
		return pos;
	}

	public void setLine(int line) {
		this.pos = line;
	}
}
