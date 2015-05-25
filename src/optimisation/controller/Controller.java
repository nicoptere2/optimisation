package optimisation.controller;

import optimisation.controller.genetic.Genetic;
import optimisation.controller.recuit.Recuit;
import optimisation.model.Model;


public class Controller {
	private static Controller instance;
	
	private Algorithme algorithme;
	
	private Thread thread;
	
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
			algorithme = new Genetic(Model.getInstance().getClavierCollection(), 4);
		
		thread = new Thread(algorithme, "Controlle");
	}

	public void execute() {
		thread.start();
	}
}
