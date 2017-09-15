package fr.aberwag.family.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.aberwag.family.domain.Membre;

@RestController
@RequestMapping("/mere")
public class MereRelationManagmentController {

	@Autowired
	private MereRelationManagmentController mereRelationManagmentController;

	@RequestMapping(method = RequestMethod.POST, value = "/ajoutMere")
	public Membre addMother(@RequestBody Membre child, @RequestBody Membre Mother) {
		return mereRelationManagmentController.addMother(child, Mother);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/suppressionMere")
	public Membre deleteMother(@RequestBody Membre child, @RequestBody Membre Mother) {
		return mereRelationManagmentController.deleteMother(child, Mother);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/ajouterMere")
	public Membre addMother(@RequestParam("fils") String childPseudo, @RequestParam("mere") String MotherPseudo) {
		return mereRelationManagmentController.addMother(childPseudo, MotherPseudo);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/supprimerMere")
	public Membre deleteMother(@RequestParam("fils") String childPseudo, @RequestParam("mere") String MotherPseudo) {
		return mereRelationManagmentController.addMother(childPseudo, MotherPseudo);
	}
}
