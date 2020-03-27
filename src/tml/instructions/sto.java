package tml.instructions;
import java.util.ArrayList;
import tml.Instruction;


/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */

/** Store Instruction: Stores a value into the specified register
 * @author joshs
 *
 */
public class sto extends Instruction {

	/** Constructor for the store instruction
	 * @param label
	 * @param args
	 */
	public sto(String label, ArrayList<String> args) {
		super(label, args);
	}
	
	/** Store the integer from arg1 into the register arg0
	 * @see Instruction#execute()
	 */
	@Override
	public void execute() {
		ArrayList<Integer> args = this.getRegisterListAsInt();
		int r = args.get(0);
		int newValue = args.get(1);
		getProcessor().setRegister(r, newValue);
	}

}
