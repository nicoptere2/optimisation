package optimisation.model.clavier;

public class Key {
	
	private char value;
	
	public Key() {
	}

	public Key(char value) {
		this.value = value;
	}
	
	public void setValue(char c) {
		this.value = c;
	}
	
	public char nextValue() {
		return value;
	}

}
