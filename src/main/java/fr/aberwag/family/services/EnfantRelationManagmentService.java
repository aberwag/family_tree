package fr.aberwag.family.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aberwag.family.domain.Membre;
import fr.aberwag.family.repositories.MembreRepository;
import lombok.NonNull;

@Service
public class EnfantRelationManagmentService {

	@Autowired
	private MembreRepository membreRepository;

	public Membre addChild(@NonNull Membre child, @NonNull Membre Father) {
		return null;
	}

	public Membre deleteChild(@NonNull Membre child, @NonNull Membre Father) {
		return null;
	}
}
