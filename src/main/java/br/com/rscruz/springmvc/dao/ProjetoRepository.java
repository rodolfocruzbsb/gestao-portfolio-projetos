package br.com.rscruz.springmvc.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.rscruz.springmvc.model.Projeto;

@Repository("projetoRepository")
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

	@Query("select distinct p from Projeto p left join fetch p.membros m order by p.id")
	List<Projeto> findAllFetchingMembers();

	@Query("select p from Projeto p left join fetch p.membros m where p.id =:id")
	Projeto findOneFetchingMembers(@Param("id") Long id);
	
	@Query("select p from Projeto p left join p.membros m left join p.gerente g where m.id = :id or g.id = :id")
	Set<Projeto> findByParticipationOfPerson(@Param("id") Long id);

}
