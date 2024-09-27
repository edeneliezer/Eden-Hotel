package Exceptions;

import java.io.Serializable;

public class NumbersOnlyException extends Exception implements Serializable{
	private static final long serialVersionUID = 1L;
	public NumbersOnlyException() {
		super("must be only numbers!");
	}

}
