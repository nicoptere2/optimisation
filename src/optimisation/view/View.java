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
		
		
		JPanel panelBtn = new JPanel();
		
		String[] algos = {"", "Recuit", "Genetic"};
        ComboBox choixAlgo = new ComboBox(algos);
        choixAlgo.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent event) {
        		 ComboBox choixAlgo = (ComboBox) event.getSource();
        		 Controller.getInstance().setAlgorithme((String) choixAlgo.getSelectedItem());
        	 }
        });
        panelBtn.add(choixAlgo);
		
		
		Bouton btnExec = new Bouton("Executer", "Execute l'algorithme de recherche de chemin");
        btnExec.addActionListener(new  ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().execute();
				vClavier.execute();
			}});
        panelBtn.add(btnExec);

        
        this.add(panelBtn, BorderLayout.EAST);
	}
}
