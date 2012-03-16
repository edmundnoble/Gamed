
package game;

public class OutOfMapException extends Exception {

	private static final long serialVersionUID = 5507515042444401L;

	public OutOfMapException(int x, int y) {
		System.out.println("OutOfMapException at point (" + x + "," + y
				+ ").");
	}
}
