package br.com.rscruz.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rscruz.springmvc.exception.NegocioException;
import br.com.rscruz.springmvc.model.Pessoa;
import br.com.rscruz.springmvc.service.PessoaService;

/**
 * <p>
 * <b>Title:</b> PessoaRestController.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Controller REST API para pessoa
 * </p>
 * 
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/pessoas")
public class PessoaRestController {

	@Autowired
	private PessoaService service;

	/**
	 * Método responsável por recuperar todas as pessoas via API
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Pessoa>> recuperarTodos() {

		final List<Pessoa> pessoas = this.service.buscarTodosCarrengandoProjetos();

		if (pessoas.isEmpty()) {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(pessoas, HttpStatus.OK);
	}

	/**
	 * Método responsável por recuperar uma pessoas por ID via API
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pessoa> buscarPorId(@PathVariable("id") final long id) {

		final Pessoa pessoa = this.service.buscarPorIdCarrengandoProjetos(id);
		if (pessoa == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(pessoa, HttpStatus.OK);
	}

	/**
	 * Método responsável por criar uma pessoa via API
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param pessoa
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Void> criar(@RequestBody final Pessoa pessoa, final UriComponentsBuilder ucBuilder) {

		try {

			this.service.salvar(pessoa);

			final HttpHeaders headers = new HttpHeaders();

			headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(pessoa.getId()).toUri());

			return new ResponseEntity<>(headers, HttpStatus.CREATED);
		} catch (final Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Método responsável por atualizar uma pessoa via API
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param id
	 * @param pessoaAtualizada
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Pessoa> atualizar(@PathVariable("id") final long id, @RequestBody final Pessoa pessoaAtualizada) {

		final Pessoa atual = this.service.buscarPorIdCarrengandoProjetos(id);

		if (atual == null) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		this.popularPessoaAtualizada(pessoaAtualizada, atual);

		try {

			this.service.salvar(atual);

			return new ResponseEntity<>(atual, HttpStatus.OK);
		} catch (final Exception e) {

			return new ResponseEntity<>(atual, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Método responsável por excluir uma pessoa via API
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletar(@PathVariable("id") final long id) {

		final Pessoa pessoa = this.service.buscarPorIdCarrengandoProjetos(id);
		if (pessoa == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		try {

			this.service.deletar(id);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (final NegocioException e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (final Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	private void popularPessoaAtualizada(final Pessoa pessoaAtualizada, final Pessoa atual) {

		atual.setCpf(pessoaAtualizada.getCpf());

		atual.setDataNascimento(pessoaAtualizada.getDataNascimento());

		atual.setFuncionario(pessoaAtualizada.isFuncionario());

		atual.setNome(pessoaAtualizada.getNome());
	}

}
