package tml.instructions;
import java.util.ArrayList;
import tml.Instruction;

/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */

/** Multiplication Instruction: multiplies two registers' values
 * @author joshs
 *
 */
public class mul extends Instruction {

	/** Constructor for the multiplication instruction
	 * @param label
	 * @param args
	 */
	public mul(String label, ArrayList<String> args) {
		super(label, args);
	}

	/** Multiplies the register values of args1 and args2
	 *  and stores the result in args0
	 * @see Instruction#execute()
	 */
	@Override
	public void execute() {
		ArrayList<Integer> args = getRegisterListAsInt();
		int r = args.get(0);
		int s1 = getProcessor().getRegister(args.get(1));
		int s2 = getProcessor().getRegister(args.get(2));
		
		getProcessor().setRegister(r, s1*s2);
	}

}
