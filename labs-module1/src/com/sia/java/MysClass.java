package com.sia.java;

/**
 * 
 * @author Boussaid
 *
 */
public class MysClass {

	private String mm;

	private int count;
	
	/**
	 * Method permet de faire ....
	 * 
	 * @return boolean si égale à 50
	 */
	public static  boolean verifierCode( ) {
		
		int i=100 ;
		
		for (int j = 0; j < i; j++) {
			if(j==50 ) {
				System.out.print("merci");
				return true;
			}
		}
		
		
		return false;
	}
	
	public static void main (String[] arg ) {
		verifierCode();
		
	}
	
}
