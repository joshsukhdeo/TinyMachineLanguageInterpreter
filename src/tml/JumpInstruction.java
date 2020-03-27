/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */
package tml;

import java.util.ArrayList;

/** Control Flow Branch Instruction that changes the ObjectCode iterator index
 * @author joshs
 *
 */
public abstract class JumpInstruction extends Instruction {

	private ObjectCode.CodeIterator currentCodeIterator;

	/** Constructor for a Control Flow Branch Instruction
	 * @param label
	 * @param args
	 */
	public JumpInstruction(String label, ArrayList<String> args) {
		super(label, args);
	}

	/** Gets the current Iterator of the code being executed
	 * @return the currentCodeIterator The iterator looping through the
	 *  ObjectCode
	 */
	public ObjectCode.CodeIterator getCurrentCodeIterator() {
		return currentCodeIterator;
	}

	/** Gets the current Iterator of the code being executed
	 * @param currentCodeIterator the currentCodeIterator to set
	 */
	public void setCurrentCodeIterator(ObjectCode.CodeIterator currentCodeIterator) {
		this.currentCodeIterator = currentCodeIterator;
	}

}
