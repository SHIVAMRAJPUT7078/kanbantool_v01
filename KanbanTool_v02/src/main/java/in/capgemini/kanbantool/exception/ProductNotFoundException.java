package in.capgemini.kanbantool.exception;

public class ProductNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This will create the ProductNotFoundException without error message
	 */
	public ProductNotFoundException() {
		super();
	}
	/**
	 * This will create the ProductNotFoundException with error message
	 * @param error
	 */
	public ProductNotFoundException(String error) {
		super(error);
	}
	

}
