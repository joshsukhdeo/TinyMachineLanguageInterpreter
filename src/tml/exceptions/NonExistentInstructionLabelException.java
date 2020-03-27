/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */
package tml.exceptions;

/** Exception for when a label for a specified index does not exist in
 *  the ObjectCode
 * @author joshs
 *
 */
public class NonExistentInstructionLabelException extends RuntimeException {

	private static final long serialVersionUID = -5199652278534978895L;

	/** Constructor for the Non Existent Instruction Label Exc
	 * 
	 */
	public NonExistentInstructionLabelException() {
		super("The specified label does not exist in the Object Code");
	}

	/**
	 * @param message
	 */
	public NonExistentInstructionLabelException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public NonExistentInstructionLabelException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NonExistentInstructionLabelException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public NonExistentInstructionLabelException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
