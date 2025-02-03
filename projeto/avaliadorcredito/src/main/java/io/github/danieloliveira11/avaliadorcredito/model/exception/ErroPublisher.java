package io.github.danieloliveira11.avaliadorcredito.model.exception;

public class ErroPublisher extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ErroPublisher(String erro) {
		super(erro);
	}

}
