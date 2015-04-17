package demo.teil1.builder;

import demo.Bewertung;

public class BewertungBuilder {

	private Bewertung bewertung = new Bewertung();

	public static BewertungBuilder createBewertung() {
		return new BewertungBuilder();
	}

	public BewertungBuilder bewerteLautstaerkeDerVortragenden(int qualitaet) {
		bewertung.setLautstaerkeDerVortragenden(qualitaet);
		return this;
	}

	public BewertungBuilder bewerteSchauspielerischesTalent(int qualitaet) {
		bewertung.setSchauspielerischesTalent(qualitaet);
		return this;
	}

	public BewertungBuilder bewerteQualitaetDerZuhoerer(int qualitaet) {
		bewertung.setQualitaetDerZuhoerer(qualitaet);
		return this;
	}

	public BewertungBuilder bewerteAction(int qualitaet) {
		bewertung.setAction(qualitaet);
		return this;
	}

	public Bewertung build() {
		return bewertung;
	}

}
