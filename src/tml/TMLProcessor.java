/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */
package tml;

/** Executes ObjectCode for a TMLInterpreter 
 * @author joshs
 *
 */
public interface TMLProcessor {

	/** Get the contents of the specified register number
	 * @param the register number to access
	 * @return the contents of the specified register
	 */
	int getRegister(int n);

	/** Set the contents of the specified register number
	 * @param the register number to access
	 * @param val the contents of the specified register
	 */
	void setRegister(int n, int val);

	/** Sets the size of machine's register
	 * @param n the register size to set
	 */
	void setRegisterAmount(int n);

	/** Prints the contents of the register
	 */
	void printRegister();
	/** Sets an Instructions processor to this, and executes the Instruction
	 *  using this processors functionalities
	 * 
	 * @param in the instruction to execute using this processor
	 */
	void execute(Instruction in);

}