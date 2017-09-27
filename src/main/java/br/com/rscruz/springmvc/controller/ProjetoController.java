package br.com.rscruz.springmvc.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.rscruz.springmvc.domain.RiscoDoProjeto;
import br.com.rscruz.springmvc.domain.StatusDoProjeto;
import br.com.rscruz.springmvc.exception.NegocioException;
import br.com.rscruz.springmvc.model.Pessoa;
import br.com.rscruz.springmvc.model.Projeto;
import br.com.rscruz.springmvc.service.PessoaService;
import br.com.rscruz.springmvc.service.ProjetoService;

@Controller
@RequestMapping("/projeto")
public class ProjetoController {

	@Autowired
	private ProjetoService service;

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = { "/", "/listar" }, method = RequestMethod.GET)
	public String listar(ModelMap model) {

		final List<Projeto> projetos = service.buscarTodosCarregandoMembros();

		model.addAttribute("projetos", projetos);

		return "projeto/listar";
	}

	@RequestMapping(value = { "/novo" }, method = RequestMethod.GET)
	public String criar(ModelMap model) {

		final Projeto projeto = new Projeto();

		model.addAttribute("projeto", projeto);

		model.addAttribute("edit", false);

		return "projeto/cadastrar";
	}

	@RequestMapping(value = { "/novo" }, method = RequestMethod.POST)
	public String salvar(@Valid Projeto projeto, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {

			return "projeto/cadastrar";
		}

		try {

			service.salvar(projeto);
		} catch (NegocioException e) {

			result.reject("error", e.getMessage());

			return "projeto/cadastrar";
		}

		model.addAttribute("mensagem", messageSource.getMessage("mensagem.acao.realizada.sucesso", new String[] {}, Locale.getDefault()));
		return "projeto/sucesso";
	}

	@RequestMapping(value = { "/editar-{id}-projeto" }, method = RequestMethod.GET)
	public String editar(@PathVariable Long id, ModelMap model) {

		Projeto projeto = service.buscarPorIdCarregandoMembros(id);

		model.addAttribute("projeto", projeto);

		model.addAttribute("edit", true);

		return "projeto/cadastrar";
	}

	@RequestMapping(value = { "/editar-{id}-projeto" }, method = RequestMethod.POST)
	public String atualizar(@Valid Projeto projeto, BindingResult result, ModelMap model, @PathVariable Long id) {

		if (result.hasErrors()) {

			return "projeto/cadastrar";
		}

		try {

			service.salvar(projeto);
		} catch (NegocioException e) {

			result.reject("error", e.getMessage());

			return "projeto/cadastrar";
		}

		model.addAttribute("mensagem", messageSource.getMessage("mensagem.acao.realizada.sucesso", new String[] {}, Locale.getDefault()));

		return "projeto/sucesso";
	}

	@RequestMapping(value = { "/deletar-{id}-projeto" }, method = RequestMethod.GET)
	public String deletar(@PathVariable Long id, final RedirectAttributes redirectAttributes) {

		try {

			service.deletar(id);
		} catch (NegocioException e) {

			redirectAttributes.addFlashAttribute("mensagemErro", e.getMessage());

		}

		return "redirect:listar";
	}

	@ModelAttribute("pessoasFuncionarioList")
	public List<Pessoa> inicializarPessoasFuncionario() {

		return pessoaService.buscarTodosFuncionarios();
	}
	
	@ModelAttribute("pessoasList")
	public List<Pessoa> inicializarPessoas() {
		
		return pessoaService.buscarTodos();
	}

	@ModelAttribute("statusList")
	public StatusDoProjeto[] inicializarStatus() {

		return service.recuperarStatus();
	}

	@ModelAttribute("riscosList")
	public RiscoDoProjeto[] inicializarRiscos() {

		return service.recuperarRiscos();
	}

}
