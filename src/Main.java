/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */

import java.io.File;
import tml.Interpreter;

/** Main Class for the assignment
 * @author joshs
 *
 */
public class Main {

	
	/** Loads a text file, instantiates a TML Interpreter, and executes the file
	 * @param args
	 */
	public static void main(String[] args) {

        File file = new File("data.txt");
        Interpreter tinyVM = new Interpreter();
        tinyVM.run(file);

	}
	

}
