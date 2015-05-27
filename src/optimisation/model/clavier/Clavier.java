package optimisation.model.clavier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Clavier implements Iterable<Key>{
	
	private Key[][] keys;
	private ArrayList<Key> keysForIterator;
	
	private final int SIZE = 40;
	
	public Clavier () {
		keys = new Key[4][10];
		keysForIterator = new ArrayList<Key>(SIZE);
		char clavier[] = new char[SIZE];
		for(int i=0; i<4; i++){
			for(int j=0; j<10; j++) {
				clavier[i] = '\0';
				keys[i][j] = new Key();
				keysForIterator.add(keys[i][j]);
			}
		}

		random(clavier);

		newState(clavier);
	}
	
	private void random(char clavier[]) {
		Random r = new Random();
		int i;
		for(char c='a'; c<='z'; c++){
			System.out.println(c);
			do{
				i = r.nextInt(40);
			}while(clavier[i] != '\0');
			
			clavier[i] = c;				
		}
	}

	public void newState(char[] c) {
		int k=0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<10; j++, k++){
				keys[i][j].setValue(c[k]);
				keys[i][j].setPosition(i);
			}
		}
	}
	
	public Key[][] getKeys() {
		return keys;
	}

	@Override
	public synchronized Iterator<Key> iterator() {
		return keysForIterator.iterator();
	}
	
}
