/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */
package tml.exceptions;

/** Exception for when a duplicate label is present in the ObjectCode
 * @author joshs
 *
 */
public class DuplicateInstructionLabelException extends RuntimeException {

	private static final long serialVersionUID = -5199652278534978895L;

	/** Constructor for a Duplicate Instruction Label Exception
	 * 
	 */
	public DuplicateInstructionLabelException() {
		super("Duplicate Label detected: the specified label already exist in the Object Code. Labels must be unique");
	}

	/**
	 * @param message
	 */
	public DuplicateInstructionLabelException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public DuplicateInstructionLabelException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DuplicateInstructionLabelException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DuplicateInstructionLabelException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
