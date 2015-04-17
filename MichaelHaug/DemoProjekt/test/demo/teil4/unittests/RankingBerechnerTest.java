package demo.teil4.unittests;

import static demo.teil1.builder.BewertungBuilder.createBewertung;
import static demo.teil1.builder.VortragBuilder.createVortrag;
import static demo.teil2.matcher.BewerteterVortragMatchers.ranking;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import demo.BewerteterVortrag;
import demo.Bewertung;
import demo.Qualitaet;
import demo.RankingBerechner;
import demo.Vortrag;

public class RankingBerechnerTest {

	@Test
	public void keineBewertungErhaeltRanking0() {
		Vortrag vortrag = createVortrag() //
				.build();
		Bewertung bewertung = createBewertung() //
				.build();

		assertThat(berechne(vortrag, bewertung), ranking(is(0)));
	}

	@Test
	public void vortragMitEinemVortragendenErhaeltRanking1() {
		Vortrag vortrag = createVortrag() //
				.withVortragender("Erster") //
				.build();
		Bewertung bewertung = createBewertung() //
				.build();

		assertThat(berechne(vortrag, bewertung), ranking(is(1)));
	}

	@Test
	public void vortragMitZweiVortragendenErhaeltRanking2() {
		Vortrag vortrag = createVortrag() //
				.withVortragender("Erster") //
				.withVortragender("Zweiter") //
				.build();
		Bewertung bewertung = createBewertung() //
				.build();

		assertThat(berechne(vortrag, bewertung), ranking(is(2)));
	}

	@Test
	public void bewertungMitNajaActionErhaeltNegativesRanking() {
		Vortrag vortrag = createVortrag() //
				.build();
		Bewertung bewertung = createBewertung() //
				.bewerteAction(Qualitaet.NAJA) //
				.build();

		assertThat(berechne(vortrag, bewertung), ranking(is(lessThan(-1000))));
	}

	@Test
	public void bewertungVonSchauspielerischemTalentErhaeltRanking61() {
		Vortrag vortrag = createVortrag() //
				.build();
		Bewertung bewertung = createBewertung() //
				.bewerteSchauspielerischesTalent(Qualitaet.EXQUISIT) //
				.build();

		assertThat(berechne(vortrag, bewertung), ranking(is(61)));
	}

	private BewerteterVortrag berechne(Vortrag vortrag, Bewertung bewertung) {
		return new RankingBerechner().berechne(vortrag, bewertung);
	}
}
