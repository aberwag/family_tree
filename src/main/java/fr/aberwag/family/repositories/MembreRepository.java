package fr.aberwag.family.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import fr.aberwag.family.domain.Membre;

@Repository
public interface MembreRepository extends PagingAndSortingRepository<Membre, String> {

	public Membre findOneByPseudo(String pseudo);

	public List<Membre> findByActifTrue();
}
