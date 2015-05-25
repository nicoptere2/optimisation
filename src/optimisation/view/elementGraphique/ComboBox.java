package optimisation.view.elementGraphique;

import java.util.Vector;

import javax.swing.JComboBox;

public class ComboBox extends JComboBox<String>{
	public ComboBox(String[] items) {
		super(items);
	}
	
	public ComboBox(Vector<String> items) {
		super(items);
	}
	
	public void add(String item) {
		super.addItem(item);
	}
}
