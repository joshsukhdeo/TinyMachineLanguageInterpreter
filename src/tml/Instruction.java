package tml;
import java.util.ArrayList;

import tml.exceptions.NonExistentProcessorException;


/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */

/** Intermediary representation of a TML Instruction
 * @author joshs
 *
 */
public abstract class Instruction {
	private String label;
	private ArrayList<String> registerList;
	private TMLProcessor processor;
	
	/** Gets the instruction's label
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/** Sets the instruction's label
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/** Gets the registerList
	 * @return the registerList as an ArrayList of strings
	 */
	public ArrayList<String> getRegisterList() {
		return registerList;
	}
	
	public static boolean isNumeric(String str) {
	    if (str == null)
	        return false;
	    return str.matches("\\d+");
	}
	
	/** Gets the registerList as integers
	 * 
	 * @return an arrayList of integers
	 */
	public ArrayList<Integer> getRegisterListAsInt(){
		ArrayList<Integer> argsAsInt = new ArrayList<>();
		for(String s:this.registerList) {
			if(isNumeric(s)) {
				argsAsInt.add(Integer.parseInt(s));
			}
		}
		return argsAsInt;
	}
	
	/** Sets the registerList
	 * @param registerList the registerList to set
	 */
	public void setRegisterList(ArrayList<String> args) {
		this.registerList = args;
	}
	
	/** Sets the processor executing the instruction
	 * @param processor the processor to set
	 */
	public void setProcessor(TMLProcessor processor) {
		this.processor = processor;
	}
	
	/** Gets the processor executing the instruction
	 * @param processor the processor to set
	 */
	public TMLProcessor getProcessor() {
		if(this.processor == null)
			throw new NonExistentProcessorException();
		return this.processor;
	}
	
	/** Clears the processor's instance from the instruction.
	 * 
	 */
	public void clearProcessor() {
		this.processor = null;
	}

	/** Constructor for an Instruction's Internal Representation
	 * 
	 */
	public Instruction() {
		super();
		this.registerList = new ArrayList<>();
	}

	/** Constructor for an Intermediate Representation of an Instruction
	 * @param label t
	 * @param registerList
	 */
	public Instruction(String label, ArrayList<String> args) {
		super();
		this.label = label;
		this.registerList = args;
	}
	
	/** Executes the instruction
	 * 
	 */
	public abstract void execute();

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Instruction [label=" + label + ", opcode=" + getClass().getSimpleName() + ", registerList=" + registerList + "]";
	}
	
	/** Get a String formatted to a Tiny Machine Language representation of the instruction
	 * 
	 *  @return a string containing the TML source code of the instruction
	 */
	 public String toTML() {
		 StringBuilder tmlBld = new StringBuilder(label + " " + getClass().getSimpleName());
		 for(String register:registerList) {
			 tmlBld.append(" " + register);
		 }
		 return tmlBld.toString();
	 }
}
