/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */
package tml.exceptions;

/** Exception for an Interpreter has no TMLProcessor specified to execute ObjectCode
 * @author joshs
 *
 */
public class NonExistentProcessorException extends RuntimeException {

	private static final long serialVersionUID = 3498710211500110165L;

	/** Constructor for a Non Existent Processor Exception
	 * 
	 */
	public NonExistentProcessorException() {
		super("There is no processor specified for this instruction");
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public NonExistentProcessorException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public NonExistentProcessorException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 */
	public NonExistentProcessorException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public NonExistentProcessorException(Throwable arg0) {
		super(arg0);
	}

}
