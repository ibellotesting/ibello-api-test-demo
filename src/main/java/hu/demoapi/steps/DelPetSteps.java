package hu.demoapi.steps;

import hu.demoapi.data.PetModel;
import hu.ibello.apitest.HttpMethod;
import hu.ibello.core.Name;
import hu.ibello.core.TestException;
import hu.ibello.transform.TransformerException;

import java.io.IOException;

@Name("Delete pet")
public class DelPetSteps extends AbstractDemoApiSteps<Long, Object> {

	private TestDataSteps testData;

	public void a_végpont_hívása_$_paraméterrel(Long input) throws IOException, TransformerException {
		sendAndReceive(input);
	}

	public void a_korábban_megjegyzett_kisállat_törlése() throws IOException, TransformerException {
		Long id = testData.kisállat_azonosító();
		if (id != null) {
			a_végpont_hívása_$_paraméterrel(id);
		} else {
			throw new TestException("Nincs megjegyzett kisállat azonosító.");
		}
	}
	
	@Override
	protected String getUrlSuffix(Long input) {
		return "pet/" + input;
	}

	@Override
	protected HttpMethod getMethod() {
		return HttpMethod.DELETE;
	}
	
	@Override
	protected PetModel getRequestBody(Long input) {
		return null;
	}

	@Override
	protected Class<Object> getOutputType() {
		return Object.class;
	}

}
