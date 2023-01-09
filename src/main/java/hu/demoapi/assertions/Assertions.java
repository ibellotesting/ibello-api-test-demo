package hu.demoapi.assertions;

import org.assertj.core.api.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Assertions {
	
	public Assertions() {
		super();
	}

	public AbstractStringAssert<?> assertThat(String actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}
	
	public AbstractBooleanAssert<?> assertThat(boolean actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}
	
	public AbstractBooleanAssert<?> assertThat(Boolean actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}
	
	public <T> ObjectAssert<T> assertThat(T actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}
	
	public <ELEMENT> ListAssert<ELEMENT> assertThat(List<? extends ELEMENT> actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}
	
	public <ELEMENT> AbstractCollectionAssert<?, Collection<? extends ELEMENT>, ELEMENT, ObjectAssert<ELEMENT>> assertThat(Set<? extends ELEMENT> actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}
	
	public AbstractBigDecimalAssert<?> assertThat(BigDecimal actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}
	
	public AbstractBigIntegerAssert<?> assertThat(BigInteger actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}
	
	public AbstractByteAssert<?> assertThat(byte actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}
	
	public AbstractByteAssert<?> assertThat(Byte actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}
	
	public AbstractIntegerAssert<?> assertThat(int actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}

	public AbstractIntegerAssert<?> assertThat(Integer actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}

	public AbstractShortAssert<?> assertThat(short actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}

	public AbstractShortAssert<?> assertThat(Short actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}

	public AbstractLongAssert<?> assertThat(long actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}

	public AbstractLongAssert<?> assertThat(Long actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}

	public AbstractFloatAssert<?> assertThat(float actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}

	public AbstractFloatAssert<?> assertThat(Float actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}

	public AbstractDoubleAssert<?> assertThat(double actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}

	public AbstractDoubleAssert<?> assertThat(Double actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}

	public AbstractCharacterAssert<?> assertThat(char actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}

	public AbstractCharacterAssert<?> assertThat(Character actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}

	public AbstractDateAssert<?> assertThat(Date actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}

	public AbstractOffsetDateTimeAssert<?> assertThat(OffsetDateTime actual) {
		return org.assertj.core.api.Assertions.assertThat(actual);
	}

}
