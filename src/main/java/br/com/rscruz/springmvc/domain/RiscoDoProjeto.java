package br.com.rscruz.springmvc.domain;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * <b>Title:</b> RiscoDoProjeto.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Representa oo domínio referente aos riscos do projeto
 * </p>
 * 
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @version 1.0.0
 */
public enum RiscoDoProjeto {

	BAIXO, MEDIO, ALTO;

	/**
	 * Método responsável por retornar o Enum em lista
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @return
	 */
	public static List<RiscoDoProjeto> toList() {

		return (List<RiscoDoProjeto>) Arrays.asList(values());
	}
}
