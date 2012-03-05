package utils;

public class InventoryFullException extends Exception {
	/**
		 * 
		 */
	private static final long serialVersionUID = -153040526720944927L;

	public InventoryFullException() {
		this(1);
	}

	public InventoryFullException(int overflow) {
		System.out.printf("Inventory too full.\n%s", overflow);
	}

}
