package optimisation.view.elementGraphique;

import javax.swing.JSpinner;

public class Spinner extends JSpinner{
	
	JSpinner.NumberEditor spinnerEditor; 
	
	public Spinner(int min, int max, int val, int pas, String str) {
		super();
		this.setToolTipText(str);
		spinnerEditor =  new JSpinner.NumberEditor(this, "###,##0");
		this.setEditor(spinnerEditor);
		
		spinnerEditor.getModel().setMinimum(min);
		spinnerEditor.getModel().setMaximum(max);
		spinnerEditor.getModel().setStepSize(pas);
		spinnerEditor.getModel().setValue(val);
	}
	
	public int getNumber() {
		return (Integer) spinnerEditor.getModel().getNumber();
	}
}
