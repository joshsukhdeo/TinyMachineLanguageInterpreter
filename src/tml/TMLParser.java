/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */
package tml;

import java.io.*;
import java.util.ArrayList;


/** Parses source code and converts it to ObjectCode for a TMLInterpreter 
 * @author joshs
 *
 */
public interface TMLParser {
	public File getFile();
	
	/** Reads a TML source code file and converts it to ObjectCode,
	 *  which is an internal representation of the source code.
	 * 
	 * @param sourceCode the sourceCode file to convert
	 * @return ObjectCode, an internal representation of the source code
	 */
	public ObjectCode read(File sourceCode);
	
	/** Reads a single string as a line and converts it to an Instruction,
	 *  which is an internal representation of the line provided.
	 * 
	 * @param line the line of code to convert
	 * @return an Internal Representation of the line as an Instruction
	 */
	public Instruction readLine(String line);
	
	/** Creates an instruction from an ArrayList of tokens
	 * 
	 * @param tokens the parameters for an Instruction
	 * @return an Instruction create from the tokens
	 */
	public Instruction createInstruction(ArrayList<String> tokens);
}
