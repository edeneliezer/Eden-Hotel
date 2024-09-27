package Exceptions;

import java.io.Serializable;

public class EmptyException extends Exception implements Serializable{

	private static final long serialVersionUID = 1L;
	public EmptyException() {
		super("Please fill in missing details!");
	}
}
