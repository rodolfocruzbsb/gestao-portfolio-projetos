package br.com.rscruz.springmvc.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Entidade<Long> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private Long id;

	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "datanascimento")
	private LocalDate dataNascimento;

	//@Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")
	@Size(max = 14)
	@Column(name = "cpf", length = 14)
	private String cpf;

	@Column(name = "funcionario")
	private boolean funcionario;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "membros")
	private Set<Projeto> projetos;

	@Override
	public Long getId() {

		return id;
	}

	@Override
	public void setId(Long id) {

		this.id = id;
	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public LocalDate getDataNascimento() {

		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {

		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {

		return cpf;
	}

	public void setCpf(String cpf) {

		this.cpf = cpf;
	}

	public boolean isFuncionario() {

		return funcionario;
	}

	public void setFuncionario(boolean funcionario) {

		this.funcionario = funcionario;
	}

	public Set<Projeto> getProjetos() {

		return projetos;
	}

	public void setProjetos(Set<Projeto> projetos) {

		this.projetos = projetos;
	}

	@Override
	public String toString() {

		return "Pessoa [id=" + id + ", nome=" + nome + "]";
	}

}
