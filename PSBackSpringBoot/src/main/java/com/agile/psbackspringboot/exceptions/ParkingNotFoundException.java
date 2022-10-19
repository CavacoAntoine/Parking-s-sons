package com.agile.psbackspringboot.exceptions;

import java.io.Serial;

public class ParkingNotFoundException extends Exception{

	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 1L;
	
	public ParkingNotFoundException(String name) {
		super("le parking "+name+" n'existe pas");
	}
	
	

}
