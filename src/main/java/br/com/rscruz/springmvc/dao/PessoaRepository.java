package br.com.rscruz.springmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.rscruz.springmvc.model.Pessoa;

@Repository("pessoaRepository")
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query("select count(p) from Pessoa p inner join p.projetos pj where p.id = :id")
	Long countProjectIsMember(@Param("id") Long id);

	@Query("select p from Pessoa p left join fetch p.projetos pj where p.id = :id")
	Pessoa findOneFetchingProjects(@Param("id") Long id);

}
