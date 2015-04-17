package demo.teil4.unittests;

import static demo.teil1.builder.KonferenzBuilder.createStandardKonferenz;

import org.junit.Test;

import demo.Validator;

public class ValidatorTest {

	private Validator validator = new Validator();

	@Test
	public void standardKonferenzIstGueltig() {
		validator.validate(createStandardKonferenz().build());
	}

	@Test(expected = RuntimeException.class)
	public void konferenzOhneTitelIstUngueltig() {
		validator.validate(createStandardKonferenz().withTitel(null).build());
	}

	@Test(expected = RuntimeException.class)
	public void konferenzMitKurzemTitelIstUngueltig() {
		validator.validate(createStandardKonferenz().withTitel("12").build());
	}

	@Test
	public void konferenzMitTitelAb3BuchstabenIstGueltig() {
		validator.validate(createStandardKonferenz().withTitel("123").build());
	}

	@Test(expected = RuntimeException.class)
	public void konferenzOhneOrtIstUngueltig() {
		validator.validate(createStandardKonferenz().withOrt(null).build());
	}

	@Test(expected = RuntimeException.class)
	public void konferenzOhneDatumIstUngueltig() {
		validator.validate(createStandardKonferenz().withDatum(null).build());
	}
}
