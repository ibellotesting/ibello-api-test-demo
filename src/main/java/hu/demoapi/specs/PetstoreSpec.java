package hu.demoapi.specs;

import hu.demoapi.steps.PetSteps;
import hu.ibello.core.Specification;
import hu.ibello.core.Test;
import hu.ibello.transform.TransformerException;

import java.io.IOException;

@Specification
public class PetstoreSpec {

	private PetSteps kisállat;

	@Test(order=1)
	public void kisállat_lekérdezhető() throws IOException, TransformerException {
		kisállat.a_végpont_hívása_$_paraméterrel(2L);
		kisállat.ellenőrzés__a_válasz_sikeres();
		kisállat.ellenőrzés__a_válaszban_nincs_hibaüzenet();
	}

}
