package model;

import model.interfaces.DicePair;

/**
 * 
 * @author Brenton Holloway SID: s3485302
 *
 */
public class DicePairImpl implements DicePair{
	final int dice1;
	final int dice2;
	final int numFaces;
	
	public DicePairImpl(int dice1, int dice2, int numFaces) {
		this.dice1 = dice1;
		this.dice2 = dice2;
		this.numFaces = numFaces;
	}
	
	
	@Override
	public int getDice1() {
		return this.dice1;
	}

	@Override
	public int getDice2() {
		return this.dice2;
	}

	@Override
	public int getNumFaces() {
		return this.numFaces;
	}

}
