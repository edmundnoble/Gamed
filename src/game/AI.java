package game;

public abstract class AI {

	public abstract Action getNextAction();
	
	public Action computeNext() {
		return getNextAction();
	}
	
}
