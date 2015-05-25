package optimisation.view;

import javax.swing.JPanel;

public class View extends JPanel{
	
	private ViewAlgo vClavier;
	
	public View () {
		vClavier = new ViewAlgo();
		this.add(vClavier);
		
	}
}
