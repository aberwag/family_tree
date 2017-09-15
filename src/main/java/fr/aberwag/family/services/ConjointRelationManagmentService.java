package fr.aberwag.family.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aberwag.family.domain.Membre;
import fr.aberwag.family.repositories.MembreRepository;
import lombok.NonNull;

@Service
public class ConjointRelationManagmentService {

	@Autowired
	private MembreRepository membreRepository;

	public Membre addConjoint(@NonNull Membre membre, @NonNull Membre conjoint) {
		membre.setConjoint(conjoint);
		return membreRepository.save(membre);
	}

	public Membre deleteConjoint(@NonNull Membre membre, @NonNull Membre conjoint) {
		membre = membreRepository.findOneByPseudo(membre.getPseudo());
		conjoint = membreRepository.findOneByPseudo(conjoint.getPseudo());

		if (membre == null || conjoint == null) {
			throw new RuntimeException();
		}

		if (!membre.getConjoint().getPseudo().equals(conjoint.getPseudo())) {
			throw new RuntimeException();
		}
		membre.setConjoint(null);
		return membreRepository.save(membre);
	}

	public Membre addConjoint(String membrePseudo, String conjointPseudo) {
		Membre membre = membreRepository.findOneByPseudo(membrePseudo);
		Membre conjoint = membreRepository.findOneByPseudo(conjointPseudo);
		if (membre == null || conjoint == null) {
			throw new RuntimeException();
		}
		membre.setConjoint(conjoint);
		return membreRepository.save(membre);
	}

	public Membre deleteConjoint(String membrePseudo, String conjointPseudo) {
		Membre membre = membreRepository.findOneByPseudo(membrePseudo);
		Membre conjoint = membreRepository.findOneByPseudo(conjointPseudo);

		if (membre == null || conjoint == null) {
			throw new RuntimeException();
		}

		if (!membre.getConjoint().getPseudo().equals(conjoint.getPseudo())) {
			throw new RuntimeException();
		}
		membre.setConjoint(conjoint);
		return membreRepository.save(membre);
	}
}
