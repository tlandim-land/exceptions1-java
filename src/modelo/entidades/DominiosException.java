package modelo.entidades;

// Exception = = = obrigatorio ser tratado
//public class DominiosException extends Exception {

// RuntimeException = = = não obrigatorio ser tratado
//public class DominiosException extends RuntimeException {

public class DominiosException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DominiosException (String msg) {
		super(msg);
	}
	
}
