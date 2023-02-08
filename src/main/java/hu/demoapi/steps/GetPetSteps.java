package hu.demoapi.steps;

import hu.demoapi.data.PetModel;
import hu.ibello.apitest.HttpMethod;
import hu.ibello.core.Name;
import hu.ibello.core.TestException;
import hu.ibello.transform.TransformerException;

import java.io.IOException;

@Name("Get pet")
public class GetPetSteps extends AbstractDemoApiSteps<Long, PetModel> {

	//GET /pet/{petID}
	private TestDataSteps testData;

	public void a_végpont_hívása_$_paraméterrel(Long input) throws IOException, TransformerException {
		sendAndReceive(input);
	}

	public void a_korábban_megjegyzett_kisállat_lekérdezése() throws IOException, TransformerException {
		Long id = testData.kisállat_azonosító();
		if (id != null) {
			a_végpont_hívása_$_paraméterrel(id);
		} else {
			throw new TestException("Nincs megjegyzett kisállat azonosító.");
		}
	}

	public void ellenőrzés__a_válaszban_kapott_kisállat_adatai_megegyeznek_$_kisállat_adataival(PetModel expPet) {
		assertions().assertThat(getOutput()).isNotNull();
		assertions().assertThat(getOutput().getName()).isEqualTo(expPet.getName());
		assertions().assertThat(getOutput().getStatus()).isEqualTo(expPet.getStatus());
	}
	
	@Override
	protected String getUrlSuffix(Long id) {
		return "pet/" + id;
	}

	@Override
	protected HttpMethod getMethod() {
		return HttpMethod.GET;
	}
	
	@Override
	protected Object getRequestBody(Long id) {
		return null;
	}

	@Override
	protected Class<PetModel> getOutputType() {
		return PetModel.class;
	}


}
