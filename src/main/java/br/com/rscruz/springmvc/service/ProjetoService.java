package br.com.rscruz.springmvc.service;

import java.util.List;

import br.com.rscruz.springmvc.domain.RiscoDoProjeto;
import br.com.rscruz.springmvc.domain.StatusDoProjeto;
import br.com.rscruz.springmvc.exception.NegocioException;
import br.com.rscruz.springmvc.model.Projeto;

/**
 * <p>
 * <b>Title:</b> ProjetoService.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Interface que define os comportamentos de negócio para um Projeto
 * </p>
 * 
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @version 1.0.0
 */
public interface ProjetoService {

	/**
	 * Método responsável por buscar todos os projetos
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @return
	 */
	List<Projeto> buscarTodos();

	/**
	 * Método responsável por salvar um projeto
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param projeto
	 * @throws NegocioException
	 */
	void salvar(Projeto projeto) throws NegocioException;

	/**
	 * Método responsável por recuperar um rojeto por ID
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param id
	 * @return
	 */
	Projeto buscarPorId(Long id);

	/**
	 * Método responsável por deletar um projeto pelo seu ID
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param id
	 */
	void deletar(Long id);

	/**
	 * Método responsável por recuperar os Status possíveis do projeto
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @return
	 */
	StatusDoProjeto[] recuperarStatus();

	/**
	 * Método responsável por recuperar os riscos possíveis do projeto
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @return
	 */
	RiscoDoProjeto[] recuperarRiscos();

	/**
	 * Método responsável por buscar todos os projetos carregando os membros de forma EAGER.
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @return
	 */
	List<Projeto> buscarTodosCarregandoMembros();

	/**
	 * Método responsável por buscar um projeto carregando os membros
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param id
	 * @return
	 */
	Projeto buscarPorIdCarregandoMembros(Long id);

}
