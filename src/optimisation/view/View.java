package optimisation.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import optimisation.controller.Controller;
import optimisation.view.elementGraphique.Bouton;
import optimisation.view.elementGraphique.ComboBox;


public class View extends JPanel{
	
	private ViewAlgo vClavier;
	
	public View () {
		vClavier = new ViewAlgo();
		this.add(vClavier, BorderLayout.WEST);
		
		
		ButtonPanel panelBtn = new ButtonPanel(vClavier);
        this.add(panelBtn, BorderLayout.EAST);
	}
}
