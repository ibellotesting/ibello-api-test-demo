package hu.demoapi.steps;

import hu.demoapi.assertions.Assertions;
import hu.ibello.core.TestException;
import hu.ibello.steps.StepLibrary;
import java.util.Collection;

public abstract class AbstractSteps extends StepLibrary {
	
	private Assertions assertions;

	protected void shouldNotBeNull(Object value, String error) {
		if (value == null) {
			throw new TestException(error);
		}
	}

	protected void shouldNotBeEmpty(Collection<?> value, String error) {
		if (value == null || value.isEmpty()) {
			throw new TestException(error);
		}
	}

	protected void shouldBeTrue(boolean value, String error) {
		if (!value) {
			throw new TestException(error);
		}
	}

	protected void shouldBeFalse(boolean value, String error) {
		if (value) {
			throw new TestException(error);
		}
	}
	
	protected Assertions assertions() {
		if (assertions == null) {
			assertions = new Assertions();
		}
		return assertions;
	}

}
