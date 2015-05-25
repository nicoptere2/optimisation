package optimisation.model.clavier;

public class Key {
	
	private char value;
	
	public Key() {
	}

	public Key(char value) {
		this.value = value;
	}
	
	public synchronized void setValue(char c) {
		this.value = c;
	}
	
	public synchronized char nextValue() {
		return value;
	}

}
