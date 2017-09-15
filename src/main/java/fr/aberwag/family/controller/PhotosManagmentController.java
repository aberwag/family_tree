package fr.aberwag.family.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.aberwag.family.domain.Membre;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/photos")
@Slf4j
public class PhotosManagmentController {

	@Autowired
	private PhotosManagmentController photosManagmentControllermembreManagmentService;

	@RequestMapping(method = RequestMethod.GET, value = "/test")
	public Membre addProfilePhoto(String pseudo, String path) {
		throw new NullPointerException();
	}

	public Membre deleteProfilePhoto(String pseudo, String path) {
		return null;
	}

	public Membre updateProfilePhoto(String pseudo, String newPath) {
		return null;
	}

}
