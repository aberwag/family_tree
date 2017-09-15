package fr.aberwag.family.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.aberwag.family.domain.Membre;
import fr.aberwag.family.exception.FamilyBusinessException;
import fr.aberwag.family.services.MembreManagmentService;

@RestController
@RequestMapping("/membre")
public class MembreManagmentController {

	@Autowired
	MembreManagmentService membreManagmentService;

	// @ExceptionHandler(FamilyBusinessException.class)
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public Membre addMembre(@RequestBody Membre membre) {
		return membreManagmentService.addMembre(membre);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/delete")
	public Membre deleteMembre(@RequestParam(name = "pseudo") String pseudo) {
		return membreManagmentService.deleteMembre(pseudo);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public Membre updateMembre(@RequestBody Membre membre) {
		return membreManagmentService.updateMembre(membre);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/get")
	public Membre getMembre(@RequestParam(name = "pseudo") String pseudo) {
		return membreManagmentService.getMembre(pseudo);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public List<Membre> getAllActiveMembre() {
		throw new FamilyBusinessException();
		// return membreManagmentService.getAllActifMembre();
	}
}