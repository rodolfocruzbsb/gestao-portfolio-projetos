package br.com.rscruz.springmvc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.rscruz.springmvc.model.Pessoa;
import br.com.rscruz.springmvc.service.PessoaService;
import br.com.rscruz.springmvc.utils.IsNullUtil;

/**
 * <p>
 * <b>Title:</b> PessoaConverter.java
 * </p>
 * 
 * <p>
 * <b>Description:</b>Converter para o Spring MVC para a entidade pessoa
 * </p>
 * 
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @version 1.0.0
 */
@Component
public class PessoaConverter implements Converter<Object, Pessoa> {

	@Autowired
	private PessoaService pessoaService;

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public Pessoa convert(final Object element) {

		Pessoa result = null;

		if (IsNullUtil.isNotNull(element)) {

			if (element instanceof Pessoa) {

				result = (Pessoa) element;
			} else {
				Long id = Long.valueOf(String.valueOf(element));

				result = id != null ? this.pessoaService.buscarPorId(id) : null;
			}
		}
		return result;
	}
}
