package fr.aberwag.family.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.aberwag.family.domain.Membre;

@RestController
@RequestMapping("/conjoint")
public class ConjointRelationManagmentController {

	@Autowired
	private ConjointRelationManagmentController conjointRelationManagmentController;

	@RequestMapping(method = RequestMethod.POST, value = "/ajoutConjoint")
	public Membre addConjoint(@RequestBody Membre child, @RequestBody Membre Conjoint) {
		return conjointRelationManagmentController.addConjoint(child, Conjoint);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/suppressionConjoint")
	public Membre deleteConjoint(@RequestBody Membre child, @RequestBody Membre Conjoint) {
		return conjointRelationManagmentController.deleteConjoint(child, Conjoint);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/ajouterConjoint")
	public Membre addConjoint(@RequestParam("fils") String childPseudo,
			@RequestParam("conjoint") String ConjointPseudo) {
		return conjointRelationManagmentController.addConjoint(childPseudo, ConjointPseudo);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/supprimerConjoint")
	public Membre deleteConjoint(@RequestParam("fils") String childPseudo,
			@RequestParam("conjoint") String ConjointPseudo) {
		return conjointRelationManagmentController.addConjoint(childPseudo, ConjointPseudo);
	}
}
