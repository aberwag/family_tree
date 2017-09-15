package fr.aberwag.family.domain;

import java.util.Date;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateString;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NodeEntity
@Data
public class Membre {

	@GraphId
	private Long id;

	@Index(unique = true, primary = true)

	@Property(name = "pseudo")
	private String pseudo;

	@Property(name = "nom")

	private String nom;

	@Property(name = "prenom")
	private String prenom;

	@Property(name = "civilite")
	private String civilite;

	@Property(name = "date_naissance")
	@DateString("yyyy-MM-dd")
	private Date dateNaissance;

	@Property(name = "lieu_naissance")
	private String lieuDeNaissance;

	@Property(name = "latitude_naissance")
	private Long latitudeNaissance;

	@Property(name = "longitude_naissance")
	private Long longitudeNaissance;

	@Property(name = "description")
	private String description;

	@Property(name = "photo")
	private String photo;

	@Property(name = "actif")
	private boolean actif;

	@Property(name = "vivant")
	private boolean vivant;

	@Property(name = "numero_portable")
	private String numeroPortable;

	@Property(name = "numero_fixe")
	private String numeroFixe;

	@Property(name = "pays_residence")
	private String paysDeResidence;

	@Property(name = "ville_residence")
	private String villeDeResidence;

	@Property(name = "adresse")
	private String adresse;

	@Property(name = "date_deces")
	@DateString("yyyy-MM-dd")
	private Date dateDeces;

	@Relationship(type = "PERE", direction = Relationship.INCOMING)
	private Membre pere;

	@Relationship(type = "MERE", direction = Relationship.INCOMING)
	private Membre mere;

	@Relationship(type = "CONJOINT", direction = Relationship.INCOMING)
	private Membre conjoint;
}
