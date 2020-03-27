/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */
package tml;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

import tml.exceptions.DuplicateInstructionLabelException;
import tml.exceptions.NonExistentInstructionLabelException;

/** ObjectCode to be executed by a TMLProcessor
 * @author joshs
 *
 */
public class ObjectCode implements Iterable<Instruction> {

	public class CodeIterator implements Iterator<Instruction>{
		private int index;

		/** Get the current index of the Instruction Set being iterated
		 * 
		 * @return the index
		 */
		public int getIndex() {
			return index;
		}
	
		/** Sets the index of the current element
		 *  to the code line number specified
		 *  
		 * @param index the index to set
		 */
		public void setIndex(int index) {
			this.index = index;
		}
		/** Sets the index of the current element
		 * 
		 * @param index the index to set
		 */
		public void setIndex(String label) {
			this.index = labelMap.get(label);
		}
		
		/** Default Constructor
		 * 
		 */
		public CodeIterator() {
			super();
			ObjectCode.this.code.iterator();
			this.index = 0;
		}
	
		/* (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return (index < ObjectCode.this.code.size());
		}
	
		/* (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		@Override
		public Instruction next() {
			if(!hasNext())
				throw new NoSuchElementException();
			Instruction in = ObjectCode.this.code.get(this.index);
			if(in instanceof JumpInstruction)
				((JumpInstruction) in).setCurrentCodeIterator(this);
			this.index++;
			return in;
		}
		
	}

	private ArrayList<Instruction> code;
	private HashMap<String, Integer> labelMap;

	/** Gets the label alias for code line numbers/indexes
	 * 
	 * @return the labelMap the HashMap of ObjectCode line index aliases
	 */
	public HashMap<String, Integer> getLabelMap() {
		return labelMap;
	}

	/** Default constructor for the Internal Representation of
	 *  the Tiny Machine InstructionSetArchicture
	 */
	public ObjectCode() {
		super();
		this.code = new ArrayList<>();
		this.labelMap = new HashMap<>();
	}

	/** Copy constructor for an ObjectCode instance
	 * 
	 * @param objCode the ObjectCode instance to copy
	 */
	public ObjectCode(ObjectCode objCode) {
		super();
		this.code = objCode.code;
		this.labelMap = objCode.labelMap;
	}
	
	/** Adds an instruction to end of the ObjectCode's ArrayList
	 * 
	 * @param instruction the instruction to add
	 */
	public void add(Instruction instruction) {
		String label = instruction.getLabel();
		if(labelMap.containsKey(label))
			throw new DuplicateInstructionLabelException();
		labelMap.put(label, this.code.size());
		this.code.add(instruction);
	}
	
	/** Tests whether the ObjectCode contains the instruction label
	 * 
	 * @param label the instruction label to test for
	 * @return true if the label exists in ObjectCode
	 */
	public boolean labelExists(String label) {
		return labelMap.containsKey(label);
	}
	
	/** Get the indexed position of a label within an ObjectCode instance
	 * 
	 * @param label the label to get the index for
	 * @return the index of the label's position with the ObjectCode
	 */
	public int getIndex(String label) {
		if(!labelExists(label))
			throw new NonExistentInstructionLabelException();
		return (labelMap.get(label) != null) ? labelMap.get(label): null;
	}
	
	/** Returns an iterator for an ObjectCode instance
	 * 
	 * @return Iterator for the Instruction Set
	 */
	public Iterator<Instruction> iterator() {
		return new CodeIterator();
	}
	
	/** Get a String formatted to a Tiny Machine Language representation 
	 *  of the ObjectCode
	 * 
	 *  @return a string containing the TML source code of the ObjectCode
	 */
	public String toTML() {
		StringBuilder tmlBld = new StringBuilder();
		CodeIterator it = new CodeIterator();
		while(it.hasNext()) {
			Instruction in = it.next();
			tmlBld.append(in.toTML() + "\n");
		}
		return tmlBld.toString();
	}

}
