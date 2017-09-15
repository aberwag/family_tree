package fr.aberwag.family.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aberwag.family.domain.Membre;
import fr.aberwag.family.repositories.MembreRepository;
import lombok.NonNull;

@Service
public class MereRelationManagmentService {

	@Autowired
	private MembreRepository membreRepository;

	public Membre addMother(@NonNull Membre child, @NonNull Membre mother) {
		child = membreRepository.findOneByPseudo(child.getPseudo());
		mother = membreRepository.findOneByPseudo(mother.getPseudo());
		if (child == null || mother == null) {
			throw new RuntimeException();
		}
		child.setMere(mother);
		return membreRepository.save(child);
	}

	public Membre deleteMother(@NonNull Membre child, @NonNull Membre mother) {
		child = membreRepository.findOneByPseudo(child.getPseudo());
		mother = membreRepository.findOneByPseudo(mother.getPseudo());
		if (child == null || mother == null) {
			throw new RuntimeException();
		}

		if (!child.getMere().getPseudo().equals(mother.getPseudo())) {
			throw new RuntimeException();
		}
		child.setMere(null);
		return membreRepository.save(child);
	}

	public Membre addMother(String childPseudo, String motherPseudo) {
		Membre child = membreRepository.findOneByPseudo(childPseudo);
		Membre mother = membreRepository.findOneByPseudo(motherPseudo);
		if (child == null || mother == null) {
			throw new RuntimeException();
		}
		child.setMere(mother);
		return membreRepository.save(child);
	}

	public Membre deleteMother(String childPseudo, String motherPseudo) {
		Membre child = membreRepository.findOneByPseudo(childPseudo);
		Membre mother = membreRepository.findOneByPseudo(motherPseudo);

		if (child == null || mother == null) {
			throw new RuntimeException();
		}

		if (!child.getMere().getPseudo().equals(mother.getPseudo())) {
			throw new RuntimeException();
		}
		child.setMere(mother);
		return membreRepository.save(child);
	}
}
