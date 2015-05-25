package optimisation.controller;

public class Controller {
	private static Controller instance;
	
	private Algorithme algorithme;
	
	protected Controller() {
	}
	
	public static Controller getInstance() {
		if(instance == null)
			instance = new Controller();
		
		return instance;
	}
}
