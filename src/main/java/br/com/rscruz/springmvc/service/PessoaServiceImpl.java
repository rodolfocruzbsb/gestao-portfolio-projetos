package br.com.rscruz.springmvc.service;

import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rscruz.springmvc.dao.PessoaRepository;
import br.com.rscruz.springmvc.dao.ProjetoRepository;
import br.com.rscruz.springmvc.exception.NegocioException;
import br.com.rscruz.springmvc.model.Pessoa;
import br.com.rscruz.springmvc.model.Projeto;
import br.com.rscruz.springmvc.utils.IsNullUtil;

@Service("pessoaService")
@Transactional
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaRepository repository;

	@Autowired
	private ProjetoRepository projetoRepository;

	@Autowired
	private MessageSource messageSource;

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.rscruz.springmvc.service.PessoaService#buscarTodos()
	 */
	@Override
	public List<Pessoa> buscarTodos() {

		return this.repository.findAll();
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.rscruz.springmvc.service.PessoaService#salvar(br.com.rscruz.springmvc.model.Pessoa)
	 */
	@Override
	public void salvar(final Pessoa pessoa) {

		this.repository.save(pessoa);

	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.rscruz.springmvc.service.PessoaService#buscarPorId(java.lang.Long)
	 */
	@Override
	public Pessoa buscarPorId(final Long id) {

		return this.repository.findOne(id);
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.rscruz.springmvc.service.PessoaService#deletar(java.lang.Long)
	 */
	@Override
	public void deletar(final Long id) {

		this.validarSeEstaVinculadaAProjeto(id);

		this.repository.delete(id);

	}

	/**
	 * Método responsável por verificar se a pessoa em questão está associada de alguma forma ao projeto(Gerente e/ou Membro)
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param id
	 */
	private void validarSeEstaVinculadaAProjeto(final Long id) {

		if (IsNullUtil.isNotNull(id)) {

			final Set<Projeto> projetosAssociadosAPessoa = this.projetoRepository.findByParticipationOfPerson(id);
			if (IsNullUtil.isNotNullOrEmpty(projetosAssociadosAPessoa)) {

				final String projetosAssociadosMsg = projetosAssociadosAPessoa.stream().map(Projeto::getNome).collect(Collectors.joining(", "));
				throw new NegocioException(this.messageSource.getMessage("mensagem.pessoa.nao.pode.ser.excluida", new String[] { projetosAssociadosMsg }, Locale.getDefault()));
			}
		}

	}

	@Override
	public Pessoa buscarPorIdCarrengandoProjetos(Long id) {

		Pessoa result = null;
		if (IsNullUtil.isNotNullOrEmpty(id)) {
			result = this.repository.findOneFetchingProjects(id);
		}
		return result;
	}

	@Override
	public List<Pessoa> buscarTodosFuncionarios() {

		final Pessoa pessoaExemplo = new Pessoa();

		pessoaExemplo.setFuncionario(true);

		Example<Pessoa> exemplo = Example.of(pessoaExemplo);

		return this.repository.findAll(exemplo);
	}

}
