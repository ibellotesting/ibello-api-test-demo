package hu.demoapi.steps;


import hu.demoapi.data.ApiResponse;
import hu.ibello.apitest.HttpMethod;
import hu.ibello.apitest.HttpResponse;
import hu.ibello.apitest.RestClient;
import hu.ibello.core.TestException;
import hu.ibello.transform.TransformerException;

import java.io.IOException;

public abstract class AbstractDemoApiSteps<INPUT, OUTPUT> extends AbstractSteps {

	private INPUT input;
	private ApiResponse error;
	private HttpResponse<OUTPUT> httpResponse;

	public void a_végpont_hívása_paraméter_nélkül() throws IOException, TransformerException {
		sendAndReceive(null);
	}

	public void ellenőrzés__a_válasz_sikeres() {
		assertions().assertThat(httpResponse).isNotNull();
		assertions().assertThat(httpResponse.getCode())
				.isGreaterThanOrEqualTo(200)
				.isLessThan(400);
	}

	public void ellenőrzés__a_válasz_sikertelen() {
		assertions().assertThat(httpResponse).isNotNull();
		assertions().assertThat(httpResponse.getCode())
				.isGreaterThan(399);
	}

	public void ellenőrzés__a_válasz_kódja_$(int expected) {
		assertions().assertThat(httpResponse).isNotNull();
		assertions().assertThat(httpResponse.getCode()).isEqualTo(expected);
	}

	public void ellenőrzés__a_válaszban_$_kódú_hiba_van(int errorCode) {
		assertions().assertThat(error).isNotNull();
		output().recordCustomExpectation("Hibaüzenet: " + error.getMessage());
		assertions().assertThat(error.getCode()).isEqualTo(errorCode);
	}
	
	public void ellenőrzés__a_válaszban_nincs_hibaüzenet() {
		assertions().assertThat(error).isNull();
	}

	protected abstract String getUrlSuffix(INPUT input);

	protected abstract HttpMethod getMethod();

	protected abstract Object getRequestBody(INPUT input);

	protected abstract Class<OUTPUT>getOutputType();

	protected void clear() {
		error = null;
	}

	protected void sendAndReceive(INPUT input) throws IOException, TransformerException {
		clear();
		this.input = input;
		httpResponse = getRestClient().sendAndReceive(getOutputType());
	}

	protected OUTPUT getOutput() {
		return httpResponse.getObject();
	}

	protected String getMimeType() {
		return "application/json";
	}

	protected String getAccept() {
		return "application/json";
	}

	private RestClient getRestClient() {
		RestClient client = restClient().withoutCertificateValidation()
				.method(getMethod())
				.accept(getAccept())
				.mimeType(getMimeType());
		Object body = getRequestBody(input);
		client.body(body);
		String url = getUrl(input);
		client.url(url);
		return client;
	}

	private String getUrl(INPUT input) {
		String url = getBaseUrl();
		if (!url.endsWith("/")) {
			url += "/";
		}
		String suffix = getUrlSuffix(input);
		if (suffix.startsWith("/")) {
			suffix = suffix.substring(1);
		}
		return url + suffix;
	}

	private String getBaseUrl() {
		String key = getClass().getPackage().getName() + ".url";
		String baseUrl = getConfigurationValue(key).toString();
		if (baseUrl == null) {
			throw new TestException(String.format("Nincs megadva a \"%s\" konfigurációs paraméter!", key));
		}
		return baseUrl;
	}

}
