/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */
package tml;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import tml.instructions.UndefinedInstructionException;

/** Contains the instructions available for a TMLInterpreter
 * @author joshs
 *
 */
public class InstructionSet {
	private HashMap<String, Class<Instruction>> availableOperations;

	/** Get available operations' opcodes
	 * 
	 * @return the availableOperations
	 */
	public Class<Instruction> getOperations(String opcode) {
		if(!availableOperations.containsKey(opcode))
			throw new UndefinedInstructionException();
		return availableOperations.get(opcode);
	}

	/** Constructs an InstructionSet from a HashMap of opcode strings to their
	 *  respective classes
	 *  
	 * @param availableOperations
	 */
	public InstructionSet(HashMap<String, Class<Instruction>> availableOperations) {
		super();
		this.availableOperations = availableOperations;
	}
	
	/** Constructs an InstructionSet from the tml.instructions package
	 * 
	 */
	public InstructionSet() {
		super();
		this.availableOperations = new HashMap<>();
        Package pkg = Package.getPackage("tml.instructions");
		this.add(pkg);
	}

	/** Add an Instruction for the Interpreter and Parser to process
	 * 
	 *  @param clazz the Class to make available for the Interpreter to use
	 *  @return true if the availableOperations HashMap is modified
	 */
	public boolean add(Class<Instruction> clazz) {
		if(clazz == null)
			return false;
		if(!Instruction.class.isAssignableFrom(clazz))
			return false;
		String opcode = clazz.getSimpleName();
		if(this.availableOperations.containsKey(opcode))
			return false;
		return (this.availableOperations.put(opcode, clazz) == null);
	}
	/** Adds all classes from a package to hashMap 
	 * <br>Reference for Reflections code: https://stackoverflow.com/questions/
	 * 1456930/how-do-i-read-all-classes-from-a-java-package-in-the-classpath
	 * <br>Reflections GitHub: https://github.com/ronmamo/reflections
	 * 
	 * @param pkg the package to add classes from
	 * @return true if the hashMap was modified.
	 */
	public boolean add(Package pkg) {
		
		Set<Class<? extends Instruction>> allClasses;
		
		// Get a reflection of the package contents
		Reflections reflect = new Reflections(pkg.getName(), new SubTypesScanner(false));
		// Get all subtypes of the reflection of the package
		allClasses = reflect.getSubTypesOf(Instruction.class);
		
		// Iterate over each class from the reflection
		Iterator<Class <? extends Instruction>> it = allClasses.iterator();
		
		boolean mapChanged = false;
		while(it.hasNext()){
			@SuppressWarnings("unchecked")
			Class<Instruction> clazz = (Class<Instruction>) it.next();
			if(clazz.getName().contains(pkg.getName()))
					mapChanged = add(clazz) || mapChanged;
		}
		return mapChanged;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InstructionSet [availableOperations=" + availableOperations + "]";
	}
}
