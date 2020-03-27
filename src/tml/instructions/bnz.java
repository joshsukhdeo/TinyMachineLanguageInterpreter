package tml.instructions;
import java.util.ArrayList;
import tml.Instruction;
import tml.JumpInstruction;

/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */

/** Be Not Zero Jump Instruction: jumps to an index if register value != 0
 * @author joshs
 *
 */
public class bnz extends JumpInstruction {

	/** Constructor for the Be Not Zero Jump Instruction
	 *  
	 * @param label An alias for the position of the instruction in the code
	 * @param args The arguments to provide the instruction
	 */
	public bnz(String label, ArrayList<String> args) {
		super(label, args);
	}

	/** Test if the register value of args0 is equal to zero
	 *  and returns to the instruction label specified in args1 if false
	 *  
	 * @see Instruction#execute()
	 */
	@Override
	public void execute() {
		ArrayList<String> args = this.getRegisterList();
		int regVal = getProcessor().getRegister(Integer.parseInt(args.get(0)));
		String label = args.get(1);
		
		if(regVal > 0)
			getCurrentCodeIterator().setIndex(label);
			
	}

}