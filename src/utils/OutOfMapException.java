
package utils;

public class OutOfMapException extends Exception {

	private static final long serialVersionUID = 5507515042444401L;

	public OutOfMapException(int x, int y) {
		System.err.printf("\nOutOfMapException at point (%d, %d).", x, y);
	}
}
