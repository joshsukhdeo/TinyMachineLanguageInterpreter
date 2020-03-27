package tml.instructions;
/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */

/** Exception for when source code contains an instruction outside of
 * 	a Parser's InstructionSet
 * @author joshs
 *
 */
public class UndefinedInstructionException extends RuntimeException {

	private static final long serialVersionUID = -1136712477791693127L;

	/** Constructs an Undefined Instruction Exception
	 * 
	 */
	public UndefinedInstructionException() {
		super("The specified instruction class does not exist or is not specified in the createInstruction method");
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public UndefinedInstructionException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public UndefinedInstructionException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 */
	public UndefinedInstructionException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public UndefinedInstructionException(Throwable arg0) {
		super(arg0);
	}

}
