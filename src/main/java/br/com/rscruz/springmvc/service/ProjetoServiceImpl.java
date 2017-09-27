package br.com.rscruz.springmvc.service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rscruz.springmvc.dao.ProjetoRepository;
import br.com.rscruz.springmvc.domain.RiscoDoProjeto;
import br.com.rscruz.springmvc.domain.StatusDoProjeto;
import br.com.rscruz.springmvc.exception.NegocioException;
import br.com.rscruz.springmvc.model.Projeto;
import br.com.rscruz.springmvc.utils.IsNullUtil;

/**
 * <p>
 * <b>Title:</b> ProjetoServiceImpl.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Implementação de regras de negócio referentes ao projeto
 * </p>
 * 
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @version 1.0.0
 */
@Service("projetoService")
@Transactional
public class ProjetoServiceImpl implements ProjetoService {

	@Autowired
	private ProjetoRepository repository;

	@Autowired
	private MessageSource messageSource;

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.rscruz.springmvc.service.ProjetoService#buscarTodos()
	 */
	@Override
	public List<Projeto> buscarTodos() {

		return this.repository.findAll();
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.rscruz.springmvc.service.ProjetoService#buscarTodosCarregandoMembros()
	 */
	@Override
	public List<Projeto> buscarTodosCarregandoMembros() {

		return this.repository.findAllFetchingMembers();
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.rscruz.springmvc.service.ProjetoService#buscarPorIdCarregandoMembros(java.lang.Long)
	 */
	@Override
	public Projeto buscarPorIdCarregandoMembros(final Long id) {

		return this.repository.findOneFetchingMembers(id);
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.rscruz.springmvc.service.ProjetoService#salvar(br.com.rscruz.springmvc.model.Projeto)
	 */
	@Override
	public void salvar(final Projeto projeto) throws NegocioException {

		this.validarDataProjeto(projeto);
		this.repository.save(projeto);

	}

	/**
	 * Método responsável por
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param projeto
	 */
	private void validarDataProjeto(final Projeto projeto) {

		if (IsNullUtil.isNotNull(projeto.getDataFim()) && IsNullUtil.isNotNull(projeto.getDataInicio())) {
			if (projeto.getDataFim().isBefore(projeto.getDataInicio())) {
				throw new NegocioException(this.messageSource.getMessage("mensagem.projeto.datafinal.anterior.datainicial", new String[] {}, Locale.getDefault()));
			}
		}
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.rscruz.springmvc.service.ProjetoService#buscarPorId(java.lang.Long)
	 */
	@Override
	public Projeto buscarPorId(final Long id) {

		return this.repository.findOne(id);
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.rscruz.springmvc.service.ProjetoService#deletar(java.lang.Long)
	 */
	@Override
	public void deletar(final Long id) {

		final Projeto projeto = this.repository.findOneFetchingMembers(id);

		if (IsNullUtil.isNotNullOrEmpty(projeto)) {
			this.validarStatusProjetoPassivelDeExclusao(projeto);

			projeto.getMembros().clear();

			this.repository.delete(projeto);
		}

	}

	private void validarStatusProjetoPassivelDeExclusao(final Projeto projeto) {

		if (IsNullUtil.isNotNullOrEmpty(projeto.getStatus())) {

			final List<StatusDoProjeto> statusDoProjetoQueNaoPermitemExclusao = Arrays.asList(new StatusDoProjeto[] { StatusDoProjeto.INICIADO, StatusDoProjeto.EM_ANDAMENTO, StatusDoProjeto.ENCERRADO });

			final boolean projetoEstaComStatusQueNaoPodeSerExcluido = statusDoProjetoQueNaoPermitemExclusao.stream().anyMatch(item -> item == projeto.getStatus());

			if (projetoEstaComStatusQueNaoPodeSerExcluido) {

				final String statusParaMensagemDeErro = statusDoProjetoQueNaoPermitemExclusao.stream().map(StatusDoProjeto::getDescricao).collect(Collectors.joining(", "));

				throw new NegocioException(this.messageSource.getMessage("mensagem.projeto.staus.nao.permite.exclusao", new String[] { statusParaMensagemDeErro, projeto.getStatus().getDescricao() }, Locale.getDefault()));
			}
		}

	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.rscruz.springmvc.service.ProjetoService#recuperarStatus()
	 */
	@Override
	public StatusDoProjeto[] recuperarStatus() {

		return StatusDoProjeto.values();
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.rscruz.springmvc.service.ProjetoService#recuperarRiscos()
	 */
	@Override
	public RiscoDoProjeto[] recuperarRiscos() {

		return RiscoDoProjeto.values();
	}

}
