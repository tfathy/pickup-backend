package error;

public class InvalidOldPasswordException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3940700235447926920L;
	
	public InvalidOldPasswordException() {
		super();
	}
	public InvalidOldPasswordException(final String message) {
		super(message);
	}
	
}
