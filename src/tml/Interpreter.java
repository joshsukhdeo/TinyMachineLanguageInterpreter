package tml;
import java.io.File;
import java.util.ArrayList;


import tml.ObjectCode.CodeIterator;

/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */

/** A Tiny Machine Language Interpreter
 * @author joshs
 *
 */
public class Interpreter {
	private InstructionSet instructionSet;
	private TMLParser preprocessor;
	private ObjectCode program;
	private TMLProcessor processor;
	
	/** Constructs an Interpreter instance with an ObjectCode instance
	 * @param program the objectCode for the instance
	 */
	public Interpreter(ObjectCode program) {
		super();
		this.program = program;
		this.processor = new Processor();
	}

	/** Default constructor
	 * 
	 */
	public Interpreter() {
		this.instructionSet = new InstructionSet();
		this.preprocessor = new Parser(instructionSet);
		this.program = new ObjectCode();
		this.processor = new Processor();
	}
	
	
	/** Constructor for specifying all the interpreters components
	 * @param instructionSet
	 * @param preprocessor
	 * @param program
	 * @param processor
	 */
	public Interpreter(InstructionSet instructionSet, TMLParser preprocessor, ObjectCode program,
			TMLProcessor processor) {
		super();
		this.instructionSet = instructionSet;
		this.preprocessor = preprocessor;
		this.program = program;
		this.processor = processor;
	}

	/**
	 * Generates ObjectCode from a TML source code file 
	 * and stores it in the Interpreter Instance
	 * @param sourceCode the source code to generate ObjectCode from
	 */
	public void load(File sourceCode) {
		this.program = preprocessor.read(sourceCode);
	}
	/** Store ObjectCode in the Interpreter Instance
	 * 
	 * @param objCode the ObjectCode to store
	 */
	public void load(ObjectCode objCode) {
		this.program = objCode;
	}

	/**Runs the ObjectCode stored in the Interpreter
	 */
	public void run() {
		run(program);
	}
	
	/** Runs the provided ObjectCode
	 * 
	 * @param objCode the ObjectCode to execute
	 */
	public void run(ObjectCode objCode) {
		System.out.println("--------- Program Source Code ---------");
		System.out.print(objCode.toTML());
		System.out.println("--------- Program Execution ---------");
		
		ObjectCode.CodeIterator it = (CodeIterator) objCode.iterator();

		while(it.hasNext()) {
			Instruction command = it.next();
			processor.execute(command);
		}
		
		System.out.println("--------- Registers Final Values ---------");
		processor.printRegister();
	}
	
	/** Generates and executes temporary ObjectCode from a TML source code file
	 * 
	 * @param sourceCode the source code to run
	 */
	public void run(File sourceCode) {
		ObjectCode temp = preprocessor.read(sourceCode);
		run(temp);
	}

	/** Executes the ObjectCode stored in the Interpreter
	 * 
	 */
	public void execute() {
		execute(program);
	}
	
	/** Executes the provided ObjectCode
	 * 
	 * @param objCode the ObjectCode to execute
	 */
	public void execute(ObjectCode objCode) {
		ObjectCode.CodeIterator it = (CodeIterator) objCode.iterator();
		while(it.hasNext()) {
			Instruction command = it.next();
			processor.execute(command);
		}
	}
	
	/** Executes the provided Tiny Machine Language file
	 * 
	 * @param sourceCode the file containing TML source code to execute
	 */
	public void execute(File sourceCode) {
		ObjectCode temp = preprocessor.read(sourceCode);
		execute(temp);
	}
	
	/** Prints each line with values as the program executes
	 * 
	 */
	public void debug() {
		System.out.println("--------- Program Source Code ---------");
		System.out.print(program.toTML());
		System.out.println("--------- Program Execution ---------");
		ObjectCode.CodeIterator it = (CodeIterator) program.iterator();
		while(it.hasNext()) {
			Instruction command = it.next();
			ArrayList<String> args = command.getRegisterList();
			String opcode = command.getClass().getName();
			String line = it.getIndex()+": "+opcode+" "+args.toString();
			
			processor.execute(command);
			int result = processor.getRegister(command.getRegisterListAsInt().get(0));
			String res = "Result is "+result+"\n";
			System.out.printf("%s %4s",line,res);
		}
		System.out.println("--------- Registers Final Values ---------");
		processor.printRegister();
	}

}
