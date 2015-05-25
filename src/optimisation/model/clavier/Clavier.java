package optimisation.model.clavier;

import java.util.ArrayList;
import java.util.Iterator;

public class Clavier implements Iterable<Key>{
	
	private Key[] keys;
	private ArrayList<Key> keysForIterator;
	
	private final int SIZE = 40;
	
	public Clavier () {
		keys = new Key[SIZE];
		keysForIterator = new ArrayList<Key>(SIZE);
		char clavier[] = new char[SIZE];
		char c = 'a';
		for(int i=0; i<SIZE; i++){
			if(i<26){
				clavier[i] = c;
				c++;
			}
			else {
				clavier[i] = '\0';
			}
			keys[i] = new Key();
			keysForIterator.add(keys[i]);
		}

		newState(clavier);
	}
	
	public void newState(char[] c) {
		for(int i=0; i<SIZE; i++) {
			keys[i].newValue(c[i]);
		}
	}

	@Override
	public Iterator<Key> iterator() {
		return keysForIterator.iterator();
	}
	
}
