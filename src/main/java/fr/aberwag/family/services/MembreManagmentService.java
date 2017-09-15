package fr.aberwag.family.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aberwag.family.Utils;
import fr.aberwag.family.domain.Membre;
import fr.aberwag.family.exception.FamilyBusinessException;
import fr.aberwag.family.repositories.MembreRepository;
import lombok.NonNull;

@Service
public class MembreManagmentService {

	@Autowired
	private MembreRepository membreRepository;

	public Membre addMembre(@NonNull Membre membre) {
		if (membreRepository.findOneByPseudo(membre.getPseudo()) != null)
			throw new FamilyBusinessException("L'utilisateur existe déja");
		return membreRepository.save(membre);
	}

	public Membre deleteMembre(String pseudo) {
		// return membreRepository.save(membre);
		Membre m = membreRepository.findOneByPseudo(pseudo);
		if (m == null) {
			throw new RuntimeException();
		}
		m.setActif(false);
		return membreRepository.save(m);
	}

	public Membre updateMembre(@NonNull Membre membre) {
		Membre m = membreRepository.findOneByPseudo(membre.getPseudo());
		if (m == null) {
			throw new RuntimeException();
		}

		m = Utils.mapper(m, membre);
		return membreRepository.save(m);
	}

	public Membre getMembre(String pseudo) {
		return membreRepository.findOneByPseudo(pseudo);
	}

	public List<Membre> getAllActifMembre() {
		return membreRepository.findByActifTrue();
	}

}
