package hu.demoapi.steps;

import hu.demoapi.data.PetModel;
import hu.ibello.apitest.HttpMethod;
import hu.ibello.core.Name;
import hu.ibello.transform.TransformerException;

import java.io.IOException;

@Name("Put pet")
public class PutPetSteps extends AbstractDemoApiSteps<PetModel, PetModel> {

	private TestDataSteps testData;

	public void a_végpont_hívása_$_tesztadattal(String testDataId) throws IOException, TransformerException {
		PetModel input = testData.kisállat_módosító_bemenet_betöltése_$_azonosítóval(testDataId);
		sendAndReceive(input);
	}
	
	@Override
	protected String getUrlSuffix(PetModel input) {
		return "pet/";
	}

	@Override
	protected HttpMethod getMethod() {
		return HttpMethod.PUT;
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
