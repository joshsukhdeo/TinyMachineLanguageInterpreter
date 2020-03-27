package tml.instructions;
import java.util.ArrayList;
import tml.Instruction;

/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */

/** Output instruction: outputs a register value to the console
 * @author joshs
 *
 */
public class out extends Instruction {

	/** Constructor for the output instruction
	 * @param label
	 * @param args
	 */
	public out(String label, ArrayList<String> args) {
		super(label, args);
	}

	/** Prints the value stored in register args0
	 * @see Instruction#execute()
	 */
	@Override
	public void execute() {
		ArrayList<Integer> args = getRegisterListAsInt();
		int val = getProcessor().getRegister(args.get(0));
		System.out.println(val);
	}

}
