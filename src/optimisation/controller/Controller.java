package optimisation.controller;

import optimisation.controller.genetic.Genetic;
import optimisation.controller.recuit.Recuit;
import optimisation.model.Model;


public class Controller {
	private static Controller instance;
	
	private Algorithme algorithme;
	
	private Thread thread;
	
	private int nbPop = 100;
	
	protected Controller() {
	}
	
	public static Controller getInstance() {
		if(instance == null)
			instance = new Controller();
		
		return instance;
	}

	public void setAlgorithme(String algo){
		if(algo == "Recuit")
			algorithme = new Recuit(Model.getInstance().getClavierCollection());
		else if(algo == "Genetic")
			algorithme = new Genetic(Model.getInstance().getClavierCollection(), nbPop);
		
		thread = new Thread(algorithme, "Controlle");
	}

	public void execute() {
		thread.start();
	}

	public void setTemperature(int temp) {
	}

	public void setPopulation(int nbPop) {
		this.nbPop = nbPop;
	}

	public void setMutation(int mut) {
		Genetic.propMutation = ((double)mut) /100;
	}
}
