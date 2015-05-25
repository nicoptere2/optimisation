package optimisation.model.clavier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Clavier implements Iterable<Key>{
	
	private Key[] keys;
	private ArrayList<Key> keysForIterator;
	
	private final int SIZE = 40;
	
	public Clavier () {
		Random r = new Random();
		keys = new Key[SIZE];
		keysForIterator = new ArrayList<Key>(SIZE);
		char clavier[] = new char[SIZE];
		for(int i=0; i<SIZE; i++){
			clavier[i] = '\0';
			keys[i] = new Key();
			keysForIterator.add(keys[i]);
		}
		
		int i;
		
		
		for(char c='a'; c<'z'; c++){
			do{
				i = r.nextInt(40);
			}while(clavier[i] != '\0');
			
			clavier[i] = c;				
		}

		newState(clavier);
	}
	
	public void newState(char[] c) {
		for(int i=0; i<SIZE; i++) {
			keys[i].setValue(c[i]);
		}
	}

	@Override
	public Iterator<Key> iterator() {
		return keysForIterator.iterator();
	}
	
}
