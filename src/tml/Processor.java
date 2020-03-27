/**
 * Name: Joshua Sukhdeo
 * Student ID: 002217503
 */
package tml;

/**
 * @author joshs
 *
 */
public class Processor implements TMLProcessor {

	private int[] registerArr;

	/**
	 * Initialize a Processor with 32 registers
	 */
	public Processor() {
		super();
		registerArr = new int[32];
	}

	/** Initializes a Processor with a pre-populated registry
	 * @param registerArr the
	 */
	public Processor(int[] registerArr) {
		super();
		this.registerArr = registerArr;
	}

	/* (non-Javadoc)
	 * @see tml.TMLProcessor#getRegister(int)
	 */
	@Override
	public int getRegister(int n) {
		if(n < 0 || n >= registerArr.length)
			throw new ArrayIndexOutOfBoundsException();
		return registerArr[n];
	}

	/* (non-Javadoc)
	 * @see tml.TMLProcessor#setRegister(int, int)
	 */
	@Override
	public void setRegister(int n, int val) {
		this.registerArr[n] = val;
	}

	/* (non-Javadoc)
	 * @see tml.TMLProcessor#setRegisterAmount(int)
	 */
	@Override
	public void setRegisterAmount(int n) {
		this.registerArr = new int[n];
	}

	private int maxRegisterValue() {
		int max = registerArr[0];
		for(int i = 1; i < registerArr.length; i++)
			max = (registerArr[i] > max) ? registerArr[i] : max;
		return max;
	}

	/* (non-Javadoc)
	 * @see tml.TMLProcessor#printRegister()
	 */
	@Override
	public void printRegister() {
		int max = maxRegisterValue();
		int digitPlaces = 0;
		while(max != 0) {
			max /= 10;
			digitPlaces++;
		}
		for(int i = 0; i < registerArr.length; i++) {
			if(i % 8 == 0)
				System.out.println();
			System.out.printf("%3d: %0"+digitPlaces+"d", i, registerArr[i]);
			System.out.print(" | ");
		}
		System.out.println();
	}
	/* (non-Javadoc)
	 * @see tml.TMLProcessor#execute(tml.Instruction)
	 */
	@Override
	public void execute(Instruction in) {
		in.setProcessor(this);
		in.execute();
		in.clearProcessor();
	}

}
