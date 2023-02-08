package hu.demoapi.steps;

import hu.demoapi.data.PetModel;
import hu.ibello.apitest.HttpMethod;
import hu.ibello.core.Name;
import hu.ibello.transform.TransformerException;

import java.io.IOException;

@Name("Post pet")
public class PostPetSteps extends AbstractDemoApiSteps<PetModel, PetModel> {

	// POST /pet
	private TestDataSteps testData;

	public void a_végpont_hívása_$_tesztadattal(String testDataId) throws IOException, TransformerException {
		PetModel input = testData.kisállat_bemenet_betöltése_$_azonosítóval(testDataId);
		sendAndReceive(input);
	}

	public void a_végpont_hívása_$_paraméterrel(PetModel input) throws IOException, TransformerException {
		sendAndReceive(input);
	}

	public Long létrehozott_kisállat_azonosítója() {
		assertions().assertThat(getOutput()).isNotNull();
		assertions().assertThat(getOutput().getId()).isNotNull();
		return getOutput().getId();
	}

	public void ellenőrzés__$_néven_létrejött_az_új_kisállat(String name) {
		assertions().assertThat(getOutput()).isNotNull();
		assertions().assertThat(getOutput().getName()).isNotNull().isNotEmpty();
		assertions().assertThat(getOutput().getName()).isEqualTo(name);
	}

	public void a_létrehozott_kisállat_azonosítójának_megjegyzése() {
		assertions().assertThat(getOutput()).isNotNull();
		assertions().assertThat(getOutput().getId()).isNotNull();
		testData.kisállat_azonosító_legyen(getOutput().getId());
	}
	
	@Override
	protected String getUrlSuffix(PetModel input) {
		return "pet/";
	}

	@Override
	protected HttpMethod getMethod() {
		return HttpMethod.POST;
	}
	
	@Override
	protected PetModel getRequestBody(PetModel input) {
		return input;
	}

	@Override
	protected Class<PetModel> getOutputType() {
		return PetModel.class;
	}

}
