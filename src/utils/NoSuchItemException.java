package utils;

public class NoSuchItemException extends Exception {
	/**
		 * 
		 */
	private static final long serialVersionUID = -3930961532495055027L;

	public NoSuchItemException(String name) {
		System.out.printf("There is no %s here.", name);
	}
}
