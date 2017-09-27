package br.com.rscruz.springmvc.domain;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * <b>Title:</b> StatusDoProjeto.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Representa o domínio referente ao status do projetoo
 * </p>
 * 
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @version 1.0.0
 */
public enum StatusDoProjeto {

	EM_ANALISE("Em análise"),

	ANALISE_REALIZADA("Análise realizada"),

	ANALISE_APROVADA("Análise aprovada"),

	INICIADO("Iniciado"),

	PLANEJADO("Planejado"),

	EM_ANDAMENTO("Em andamento"),

	ENCERRADO("Encerrado"),

	CANCELADO("Cancelado");

	private String descricao;

	private StatusDoProjeto( String descricao ) {
		this.descricao = descricao;
	}

	public String getDescricao() {

		return this.descricao;
	}

	/**
	 * Método responsável por retornar o Enum em lista
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @return
	 */
	public static List<StatusDoProjeto> toList() {

		return (List<StatusDoProjeto>) Arrays.asList(values());
	}

}
