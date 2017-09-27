package br.com.rscruz.springmvc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.rscruz.springmvc.converter.PessoaConverter;

@Configuration
@EnableWebMvc
public class WebAppConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private PessoaConverter pessoaConverter;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		/* BOOTSTRAP */
		registry.addResourceHandler("/bootstrap/css/**").addResourceLocations("/public/resources/bootstrap/css/");
		registry.addResourceHandler("/bootstrap/js/**").addResourceLocations("/public/resources/bootstrap/js/");

		/* POPPER */
		registry.addResourceHandler("/popper/js/**").addResourceLocations("/public/resources/popper/js/");

		/* JQUERY */
		registry.addResourceHandler("/jquery/slim/js/**").addResourceLocations("/public/resources/jquery/slim/js/");

		/* BOOTBOX */
		registry.addResourceHandler("/bootbox/js/**").addResourceLocations("/public/resources/bootbox/js/");
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {

		registry.addConverter(pessoaConverter);
	}
}
