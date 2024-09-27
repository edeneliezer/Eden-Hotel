package Exceptions;

import java.io.Serializable;

public class LettersOnlyException extends Exception implements Serializable{

	private static final long serialVersionUID = 1L;
	public LettersOnlyException() {
		super("must be letters only!");
	}
}
