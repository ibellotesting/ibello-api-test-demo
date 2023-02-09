package hu.demoapi.specs;

import hu.demoapi.data.PetModel;
import hu.demoapi.steps.DelPetSteps;
import hu.demoapi.steps.GetPetSteps;
import hu.demoapi.steps.PostPetSteps;
import hu.demoapi.steps.PutPetSteps;
import hu.ibello.core.Specification;
import hu.ibello.core.Test;
import hu.ibello.core.TestException;
import hu.ibello.transform.TransformerException;

import java.io.IOException;

@Specification
public class PetstoreSpec {

	private GetPetSteps getPet;
	private PostPetSteps postPet;
	private PutPetSteps putPet;
	private DelPetSteps delPet;

	//ibello run -j*PetstoreSpec*

	@Test(order=1)
	public void kisállat_létrehozható() throws IOException, TransformerException {
		postPet.a_végpont_hívása_$_tesztadattal("zsomi");
		postPet.ellenőrzés__a_válasz_sikeres();
		postPet.ellenőrzés__$_néven_létrejött_az_új_kisállat("Zsömi");
		postPet.a_létrehozott_kisállat_azonosítójának_megjegyzése();
	}

	@Test(order=2)
	public void kisállat_lekérdezhető() throws IOException, TransformerException {
		getPet.a_korábban_megjegyzett_kisállat_lekérdezése();
		getPet.ellenőrzés__a_válasz_sikeres();
	}

	@Test(order=3)
	public void kisállat_módosítható() throws IOException, TransformerException {
		putPet.a_végpont_hívása_$_tesztadattal("mira");
		putPet.ellenőrzés__a_válasz_sikeres();
	}

	@Test(order=4)
	public void kisállat_törölhető() throws IOException, TransformerException {
		delPet.a_korábban_megjegyzett_kisállat_törlése();
		delPet.ellenőrzés__a_válasz_sikeres();
		getPet.a_korábban_megjegyzett_kisállat_lekérdezése();
		getPet.ellenőrzés__a_válasz_kódja_$(404);
	}

}
