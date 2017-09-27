package br.com.rscruz.springmvc.exception;

public class NegocioException extends RuntimeException {

	public NegocioException() {
	}

	public NegocioException( String mensagem ) {
		super(mensagem);
	}

	public NegocioException( String mensagem, Throwable cause ) {
		super(mensagem, cause);
	}
		
}
