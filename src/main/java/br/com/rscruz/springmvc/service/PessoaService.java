package br.com.rscruz.springmvc.service;

import java.util.List;

import br.com.rscruz.springmvc.model.Pessoa;

/**
 * <p>
 * <b>Title:</b> PessoaService.java
 * </p>
 * 
 * <p>
 * <b>Description:</b>Interface que define os comportamentos de negócio para uma Pessoa
 * </p>
 * 
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @version 1.0.0
 */
public interface PessoaService {

	/**
	 * Método responsável por recuperar todas as Pessoas
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @return
	 */
	List<Pessoa> buscarTodos();

	/**
	 * Método responsável por salvar uma pessoa
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param pessoa
	 */
	void salvar(Pessoa pessoa);

	/**
	 * Método responsável por recuperar baseado no ID
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param id
	 * @return
	 */
	Pessoa buscarPorId(Long id);

	/**
	 * Método responsável por recuperar uma pessoa pelo seu ID carregndo os projetos de forma EAGER
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param id
	 * @return
	 */
	Pessoa buscarPorIdCarrengandoProjetos(Long id);

	/**
	 * Método responsável por deletar por ID
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param id
	 */
	void deletar(Long id);

	/**
	 * Método responsável por recuperar todas as pessoas que são funcionário
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @return
	 */
	List<Pessoa> buscarTodosFuncionarios();

	/**
	 * Método responsável por recuperar todas as pessoas carrengando seus respectivos projetos
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @return
	 */
	List<Pessoa> buscarTodosCarrengandoProjetos();

}
