package Exceptions;

import java.io.Serializable;

public class PersonAlreadyExistException extends Exception implements Serializable{

	private static final long serialVersionUID = 1L;
	public PersonAlreadyExistException(String fname, String lname) {
		super(fname +" "+lname+" already exists in the system, will not be added again");
	}
	

}
