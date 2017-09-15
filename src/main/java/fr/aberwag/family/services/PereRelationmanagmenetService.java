package fr.aberwag.family.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aberwag.family.domain.Membre;
import fr.aberwag.family.repositories.MembreRepository;
import lombok.NonNull;

@Service
public class PereRelationmanagmenetService {

	@Autowired
	private MembreRepository membreRepository;

	public Membre addFather(@NonNull Membre child, @NonNull Membre father) {
		child = membreRepository.findOneByPseudo(child.getPseudo());
		father = membreRepository.findOneByPseudo(father.getPseudo());
		if (child == null || father == null) {
			throw new RuntimeException();
		}
		child.setPere(father);
		return membreRepository.save(child);
	}

	public Membre deleteFather(@NonNull Membre child, @NonNull Membre father) {
		child = membreRepository.findOneByPseudo(child.getPseudo());
		father = membreRepository.findOneByPseudo(father.getPseudo());

		if (child == null || father == null) {
			throw new RuntimeException("le fils et le pere doivent etre present dans la base de données");
		}

		if (!child.getPere().getPseudo().equals(father.getPseudo())) {
			throw new RuntimeException("Il n'y a pas de relation pere-fils entre les personnes choisis");
		}
		child.setPere(null);
		return membreRepository.save(child);
	}

	public Membre addFather(String childPseudo, String fatherPseudo) {
		Membre child = membreRepository.findOneByPseudo(childPseudo);
		Membre father = membreRepository.findOneByPseudo(fatherPseudo);
		if (child == null || father == null) {
			throw new RuntimeException();
		}
		child.setPere(father);
		return membreRepository.save(child);
	}

	public Membre deleteFather(String childPseudo, String fatherPseudo) {
		Membre child = membreRepository.findOneByPseudo(childPseudo);
		Membre father = membreRepository.findOneByPseudo(fatherPseudo);

		if (child == null || father == null) {
			throw new RuntimeException();
		}

		if (!child.getPere().getPseudo().equals(father.getPseudo())) {
			throw new RuntimeException();
		}
		child.setPere(father);
		return membreRepository.save(child);
	}
}
