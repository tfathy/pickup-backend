package net.driver.pickupsa.security.error;

public class InvalidOldPasswordException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2561056286798649454L;
	public InvalidOldPasswordException() {
		super();
	}
	public InvalidOldPasswordException(final String message) {
		super(message);
	}

}
