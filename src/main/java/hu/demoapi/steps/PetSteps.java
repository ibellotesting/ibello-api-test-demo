package hu.demoapi.steps;

import hu.demoapi.data.PetModel;
import hu.ibello.apitest.HttpMethod;
import hu.ibello.core.Name;
import hu.ibello.transform.TransformerException;

import java.io.IOException;

@Name("Pet steps")
public class PetSteps extends AbstractDemoApiSteps<Long, PetModel> {

	public void a_végpont_hívása_$_paraméterrel(Long input) throws IOException, TransformerException {
		sendAndReceive(input);
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
