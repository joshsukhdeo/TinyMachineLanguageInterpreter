/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */
package tml;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import tml.instructions.UndefinedInstructionException;


/** Parses a text file into Instructions for a TMLInterpreter
 * @author joshs
 *
 */
public class Parser implements TMLParser {
	private InstructionSet opSet;

	/** Constructs a Parser with the functionality of the provided InstructionSet
	 * @param operations
	 */
	public Parser(InstructionSet opSet) {
		super();
		this.opSet = opSet;
	}

	/* (non-Javadoc)
	 * @see tml.TMLParser#getFile()
	 */
	@Override
	public File getFile() {
		return null;
	}

	/* (non-Javadoc)
	 * @see tml.TMLParser#read(java.io.File)
	 */
	@Override
	public ObjectCode read(File sourceCode) {
        ObjectCode code = new ObjectCode();
        
        try {
            Scanner scanner = new Scanner(sourceCode);
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
            	Instruction in = readLine(scanner.next());
            	code.add(in);
            }
        
            scanner.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		return code;
	}

	/* (non-Javadoc)
	 * @see tml.TMLParser#readLine(java.lang.String)
	 */
	@Override
	public Instruction readLine(String line) {
    	Scanner scan = new Scanner(line);
    	ArrayList<String> tokens = new ArrayList<>();
    	while(scan.hasNext()) {
    		tokens.add(scan.next()); // scanner.next() returns the next 
    	}
    	scan.close();
		return this.createInstruction(tokens);
	}

	/* (non-Javadoc)
	 * @see tml.TMLParser#createInstruction(java.lang.String)
	 */
	@Override
	public Instruction createInstruction(ArrayList<String> tokens) {
		String label = tokens.get(0);
		String opcode = tokens.get(1);
		tokens.remove(1);
		tokens.remove(0);
		Instruction in;
		Class<Instruction> opClass = opSet.getOperations(opcode);
		Class<?>[] parameterTypes = new Class<?>[] {label.getClass(), tokens.getClass()};
		Object[] initargs = new Object[] { label, tokens };
		try {
			in = opClass.getConstructor(parameterTypes).newInstance(initargs);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UndefinedInstructionException();
		}

		return in;
	}

}
