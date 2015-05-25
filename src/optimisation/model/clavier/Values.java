package optimisation.model.clavier;

import java.util.LinkedList;
import java.util.Queue;

public class Values {
	private Queue<Character> values;

	public Values() {
		this.values = new LinkedList<Character>();
	}
	
	public Character poll() {
		return values.poll();
	}
	
	public void add(Character c) {
		values.add(c);
	}
}
