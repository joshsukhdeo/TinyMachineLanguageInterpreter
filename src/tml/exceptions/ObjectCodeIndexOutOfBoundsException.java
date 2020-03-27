/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */
package tml.exceptions;

/** Exception for when an ObjectCode index is out of bounds
 * @author joshs
 *
 */
public class ObjectCodeIndexOutOfBoundsException extends RuntimeException {

	private static final long serialVersionUID = -7071974855808954306L;

	/** Constructor for when ObjectCode index is out of bound
	 * 
	 */
	public ObjectCodeIndexOutOfBoundsException() {
		super("ObjectCode index is out of bounds.");
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public ObjectCodeIndexOutOfBoundsException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public ObjectCodeIndexOutOfBoundsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 */
	public ObjectCodeIndexOutOfBoundsException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public ObjectCodeIndexOutOfBoundsException(Throwable arg0) {
		super(arg0);
	}

}
