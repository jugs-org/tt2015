package demo.teil1.builder;

import java.util.Date;

import demo.Konferenz;
import demo.Ort;

public class KonferenzBuilder {

	private Konferenz konferenz = new Konferenz();

	public static KonferenzBuilder createKonferenz() {
		return new KonferenzBuilder();
	}

	public KonferenzBuilder withDatum(Date datum) {
		konferenz.setDatum(datum);
		return this;
	}

	public KonferenzBuilder withTitel(String titel) {
		konferenz.setTitel(titel);
		return this;
	}

	public KonferenzBuilder withOrt(Ort ort) {
		konferenz.setOrt(ort);
		return this;
	}

	public Konferenz build() {
		return konferenz;
	}

	public static KonferenzBuilder createStandardKonferenz() {
		return createKonferenz() //
				.withDatum(new Date()) //
				.withTitel("Stuttgarter Testtage 2015") //
				.withOrt(new Ort("Stuttgart", "Waldheim", 48.78, 9.18));
	}

}
