package br.com.projeto.exception;

public class NoInventoryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8429960547297827346L;

	public NoInventoryException(String message) {
		super(message);
	}
}
