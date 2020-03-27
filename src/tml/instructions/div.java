package tml.instructions;
import java.util.ArrayList;

import tml.Instruction;


/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */

/** Division Instruction: divides a register value by another's value
 * @author joshs
 *
 */
public class div extends Instruction {

	/** Constructor for the division instruction
	 * @param label
	 * @param args
	 */
	public div(String label, ArrayList<String> args) {
		super(label, args);
	}

	/** Divides the register values of args1 by args2
	 *  and stores it in arg0
	 * @see Instruction#execute()
	 */
	@Override
	public void execute() {
		ArrayList<Integer> args = getRegisterListAsInt();
		int r = args.get(0);
		int s1 = getProcessor().getRegister(args.get(1));
		int s2 = getProcessor().getRegister(args.get(2));
		
		getProcessor().setRegister(r, s1/s2);
	}

}
