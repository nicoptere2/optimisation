package optimisation.model.clavier;

public class Key {
	
	private Values values;

	public Key() {
		values = new Values();
	}
	
	public void newValue(Character c) {
		values.add(c);
	}
	
	public Character nextValue() {
		return values.poll();
	}

}
