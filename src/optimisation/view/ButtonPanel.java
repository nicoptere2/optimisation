package optimisation.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import optimisation.controller.Controller;
import optimisation.view.elementGraphique.Bouton;
import optimisation.view.elementGraphique.ComboBox;
import optimisation.view.elementGraphique.Spinner;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel{
	
	private ViewAlgo vClavier;
	
	public ButtonPanel(ViewAlgo vC) {
		
		GridLayout grid = new GridLayout(5, 1);
		this.setLayout(grid);
		
		this.vClavier = vC;
		
		final JPanel pnlTemp = new JPanel();
        JLabel labTemp = new JLabel("Temperature : ");
        final Spinner spinTemp = new Spinner(0, 10000, 8000, 1, "Temperature pour le recuit simulé");
        
        final JPanel pnlPop = new JPanel();
        JLabel labPop = new JLabel("Population : ");
        final Spinner spinPop = new Spinner(0, 1000, 100, 1, "taille de la population");
        
        final JPanel pnlMut = new JPanel();
        JLabel labMut = new JLabel("Mutation : ");
        final Spinner spinMut = new Spinner(0, 100, 10, 1, "Mutation");
		
		
		String[] algos = {"", "Recuit", "Genetic"};
        ComboBox choixAlgo = new ComboBox(algos);
        choixAlgo.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent event) {
        		 ComboBox choixAlgo = (ComboBox) event.getSource();
        		 String algo = (String) choixAlgo.getSelectedItem();
        		 if(algo == "Genetic") {
        			 spinTemp.desable();
        			 spinPop.enable();
        			 spinMut.enable();
        		 }
        		 else if(algo == "Recuit") {
        			 spinTemp.enable();
        			 spinPop.desable();
        			 spinMut.desable();
        		 }
        		 Controller.getInstance().setAlgorithme(algo);
        	 }
        });
        //grid.addLayoutComponent("testA", choixAlgo);
        this.add(choixAlgo);
        
        
        pnlTemp.add(labTemp);
        spinTemp.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				Spinner spin = (Spinner) arg0.getSource(); 
				int temp = spin.getNumber();
				Controller.getInstance().setTemperature(temp);
			}
        });
        pnlTemp.add(spinTemp);
		this.add(pnlTemp);
		
		
		pnlPop.add(labPop);
        spinPop.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				Spinner spin = (Spinner) arg0.getSource(); 
				int temp = spin.getNumber();
				Controller.getInstance().setPopulation(temp);
			}
        });
        pnlPop.add(spinPop);
		this.add(pnlPop);
		
		pnlMut.add(labMut);
        spinMut.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				Spinner spin = (Spinner) arg0.getSource(); 
				int mut = spin.getNumber();
				Controller.getInstance().setMutation(mut);
			}
        });
        pnlMut.add(spinMut);
		this.add(pnlMut);
		
		Bouton btnExec = new Bouton("Executer", "Execute l'algorithme de recherche de chemin");
        btnExec.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spinTemp.desable();
	   			spinPop.desable();
	   			spinMut.desable();
				Controller.getInstance().execute();
				vClavier.execute();
			}});
        this.add("test2", btnExec);
        
        
	}
}
