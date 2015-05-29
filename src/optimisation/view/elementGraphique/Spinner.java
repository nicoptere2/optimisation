package optimisation.view.elementGraphique;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner.DefaultEditor;

public class Spinner extends JSpinner{
	
	JSpinner.NumberEditor spinnerEditor;
	
	private int min;
	private int max;
	
	private int val;
	
	private int pas;
	
	public Spinner(int min, int max, int val, int pas, String str) {
		super();
		this.min = min;
		this.max = max;
		this.val = val;
		this.pas = pas;
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
	
	public void desable() {
		((DefaultEditor) this.getEditor()).getTextField().setEditable(false);
		this.setModel(new SpinnerNumberModel(this.val, this.min, this.max, 0));
	}
	
	public void enable() {
		((DefaultEditor) this.getEditor()).getTextField().setEditable(true);
		this.setModel(new SpinnerNumberModel(this.val, this.min, this.max, this.pas));
	}
}
