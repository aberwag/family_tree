package fr.aberwag.family.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.aberwag.family.domain.Membre;
import fr.aberwag.family.services.PereRelationmanagmenetService;

@RestController
@RequestMapping("/pere")
public class PereRelationManagmentController {

	@Autowired
	private PereRelationmanagmenetService pereRelationmanagmenetService;

	@RequestMapping(method = RequestMethod.POST, value = "/ajoutPere")
	public Membre addFather(@RequestBody Membre child, @RequestBody Membre Father) {
		return pereRelationmanagmenetService.addFather(child, Father);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/suppressionPere")
	public Membre deleteFather(@RequestBody Membre child, @RequestBody Membre Father) {
		return pereRelationmanagmenetService.deleteFather(child, Father);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/ajouterPere")
	public Membre addFather(@RequestParam("fils") String childPseudo, @RequestParam("pere") String FatherPseudo) {
		return pereRelationmanagmenetService.addFather(childPseudo, FatherPseudo);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/supprimerPere")
	public Membre deleteFather(@RequestParam("fils") String childPseudo, @RequestParam("pere") String FatherPseudo) {
		return pereRelationmanagmenetService.addFather(childPseudo, FatherPseudo);
	}
}
