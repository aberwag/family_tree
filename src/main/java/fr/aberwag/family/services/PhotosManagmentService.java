package fr.aberwag.family.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aberwag.family.domain.Membre;
import fr.aberwag.family.repositories.MembreRepository;

@Service
public class PhotosManagmentService {

	@Autowired
	private MembreRepository membreRepository;

	public Membre addProfilePhoto(String pseudo, String path) {
		return null;
	}

	public Membre deleteProfilePhoto(String pseudo, String path) {
		return null;
	}

	public Membre updateProfilePhoto(String pseudo, String newPath) {
		return null;
	}

}
