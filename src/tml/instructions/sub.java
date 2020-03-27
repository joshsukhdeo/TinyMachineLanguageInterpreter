package tml.instructions;
import java.util.ArrayList;
import tml.Instruction;

/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */

/**
 * @author joshs
 *
 */
public class sub extends Instruction {

	/** Constructor for the subtraction instruction
	 * @param label
	 * @param args
	 */
	public sub(String label, ArrayList<String> args) {
		super(label, args);
	}

	/** Subtracts args2 register's value from args1 register's value 
	 *  and stores the result in args0
	 * @see Instruction#execute()
	 */
	@Override
	public void execute() {
		ArrayList<Integer> args = getRegisterListAsInt();
		int r = args.get(0);
		int s1 = getProcessor().getRegister(args.get(1));
		int s2 = getProcessor().getRegister(args.get(2));
		getProcessor().setRegister(r, s1-s2);
	}

}
