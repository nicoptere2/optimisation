package optimisation.model.clavier;

public class Key {
	
	private char value;
	private int position;
	
	public Key() {
	}

	public Key(char value) {
		this.value = value;
	}
	
	public synchronized void setValue(char c) {
		this.value = c;
	}
	
	public synchronized char getValue() {
		return value;
	}

	public void setPosition(int i) {
		// TODO Auto-generated method stub
	}


}
