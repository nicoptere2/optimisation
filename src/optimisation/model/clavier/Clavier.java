package optimisation.model.clavier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Clavier implements Iterable<Key>{
	
	private Key[][] keys;
	private ArrayList<Key> keysForIterator;
	
	private final int SIZE = 40;
	
	private boolean isShown = true;
	
	private ClavierCollection claviers;
	
	private double score;
	
	public Clavier (ClavierCollection cC) {
		this.claviers = cC;
		keys = new Key[4][10];
		keysForIterator = new ArrayList<Key>(SIZE);
		char[] clavier = new char[SIZE];
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
	
	private void random(char[] clavier) {
		Random r = new Random();
		int i;
		for(char c='A'; c<='Z'; c++){
			//System.out.println(c);
			do{
				//System.out.println("coucou");
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

	public synchronized void best() {
		this.claviers.best = this;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Key[][] getKeys() {
		return keys;
	}
	
	public void setKeys(Key[][] k){
		for(int i =0;i<k.length;i++){
			for(int j =0;j<k[0].length;j++){
				this.keys[i][j].setValue(
						k[i][j].getValue());
			}
		}
			//this.keys[i] = k[i].clone();
	}

	public synchronized Iterator<Key> iterator() {
		return keysForIterator.iterator();
	}
	

	public synchronized void echange(Key k1, Key k2) {
		char tmp;
		tmp = k1.getValue();
		k1.setValue(k2.getValue());
		k2.setValue(tmp);
	}
	
	public synchronized Clavier echange(int i ,int j ,int k ,int l){
		char tmp;
		Clavier c = new Clavier(claviers);
		c.setKeys(this.getKeys());;
		/*
		try {
			c = (Clavier)this.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		tmp = c.getKeys()[i][j].getValue();
		//tmp = k1.getValue();
		c.getKeys()[i][j].setValue(c.getKeys()[k][l].getValue());
		//k1.setValue(k2.getValue());
		c.getKeys()[k][l].setValue(tmp);
		//k2.setValue(tmp);
		return c;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for(int i=0; i<4; i++) {
			for(int j=0; j<10; j++){
				sb.append(keys[i][j].getValue());
				sb.append(',');
			}
		}
		sb.append('}');
		return sb.toString();
	}
}
