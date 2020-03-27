package tml.instructions;
import java.util.ArrayList;
import tml.Instruction;

/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */

/** Addition Instruction
 * @author joshs
 *
 */
public class add extends Instruction {

	/** Constructor for the addition instruction
	 * 
	 * @param label
	 * @param args
	 */
	public add(String label, ArrayList<String> args) {
		super(label, args);
	}

	/** Adds args2 register value to args1 register value
	 *  and stores the result in args0
	 * @see Instruction#execute()
	 */
	@Override
	public void execute() {
		ArrayList<Integer> args = getRegisterListAsInt();
		int r = args.get(0);
		int s1 = getProcessor().getRegister(args.get(1));
		int s2 = getProcessor().getRegister(args.get(2));
		getProcessor().setRegister(r, s1+s2);
	}

}
