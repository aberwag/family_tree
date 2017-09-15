package fr.aberwag.family.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.aberwag.family.domain.Membre;

@RestController
@RequestMapping("/photos")
public class PhotosManagmentController {

	@Autowired
	private PhotosManagmentController photosManagmentControllermembreManagmentService;

	@ExceptionHandler(NullPointerException.class)
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
