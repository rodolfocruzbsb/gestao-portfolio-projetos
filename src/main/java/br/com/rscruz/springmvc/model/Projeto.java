package br.com.rscruz.springmvc.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.rscruz.springmvc.domain.RiscoDoProjeto;
import br.com.rscruz.springmvc.domain.StatusDoProjeto;

@Entity
@Table(name = "projeto")
public class Projeto implements Entidade<Long> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private Long id;

	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "nome", length = 200, nullable = false)
	private String nome;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_inicio")
	private LocalDate dataInicio;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_previsao_fim")
	private LocalDate dataPrevisaoFim;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_fim")
	private LocalDate dataFim;

	@Size(max = 5000)
	@Column(name = "descricao", length = 5000)
	private String descricao;

	@Column(name = "status", length = 45)
	@Enumerated(EnumType.STRING)
	private StatusDoProjeto status;

	@Column(name = "orcamento")
	private Double orcamento;

	@Column(name = "risco", length = 45)
	@Enumerated(EnumType.STRING)
	private RiscoDoProjeto risco;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "idgerente", nullable = false)
	private Pessoa gerente;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH })
	@JoinTable(name = "membros",

			joinColumns = { @JoinColumn(name = "idprojeto", nullable = false, updatable = false) },

			inverseJoinColumns = { @JoinColumn(name = "idpessoa", nullable = false, updatable = false) })
	private Set<Pessoa> membros;

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

	public LocalDate getDataInicio() {

		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {

		this.dataInicio = dataInicio;
	}

	public LocalDate getDataPrevisaoFim() {

		return dataPrevisaoFim;
	}

	public void setDataPrevisaoFim(LocalDate dataPrevisaoFim) {

		this.dataPrevisaoFim = dataPrevisaoFim;
	}

	public LocalDate getDataFim() {

		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {

		this.dataFim = dataFim;
	}

	public String getDescricao() {

		return descricao;
	}

	public void setDescricao(String descricao) {

		this.descricao = descricao;
	}

	public StatusDoProjeto getStatus() {

		return status;
	}

	public void setStatus(StatusDoProjeto status) {

		this.status = status;
	}

	public Double getOrcamento() {

		return orcamento;
	}

	public void setOrcamento(Double orcamento) {

		this.orcamento = orcamento;
	}

	public RiscoDoProjeto getRisco() {

		return risco;
	}

	public void setRisco(RiscoDoProjeto risco) {

		this.risco = risco;
	}

	public Pessoa getGerente() {

		return gerente;
	}

	public void setGerente(Pessoa gerente) {

		this.gerente = gerente;
	}

	public Set<Pessoa> getMembros() {

		return membros;
	}

	public void setMembros(Set<Pessoa> membros) {

		this.membros = membros;
	}

	@Override
	public String toString() {

		return "Projeto [id=" + id + ", nome=" + nome + "]";
	}

}
