package fr.aberwag.family.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.aberwag.family.domain.Membre;

@RestController
@RequestMapping("/enfant")
public class EnfantRelationManagmentController {

	@Autowired
	private EnfantRelationManagmentController enfantRelationManagmentController;

	@RequestMapping(method = RequestMethod.POST, value = "/ajoutEnfant")
	public Membre addEnfant(@RequestBody Membre child, @RequestBody Membre Enfant) {
		return enfantRelationManagmentController.addEnfant(child, Enfant);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/suppressionEnfant")
	public Membre deleteEnfant(@RequestBody Membre child, @RequestBody Membre Enfant) {
		return enfantRelationManagmentController.deleteEnfant(child, Enfant);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/ajouterEnfant")
	public Membre addEnfant(@RequestParam("fils") String childPseudo, @RequestParam("enfant") String EnfantPseudo) {
		return enfantRelationManagmentController.addEnfant(childPseudo, EnfantPseudo);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/supprimerEnfant")
	public Membre deleteEnfant(@RequestParam("fils") String childPseudo, @RequestParam("enfant") String EnfantPseudo) {
		return enfantRelationManagmentController.addEnfant(childPseudo, EnfantPseudo);
	}
}
