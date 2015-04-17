package demo.teil3.java8;

import static demo.teil1.builder.KonferenzBuilder.createStandardKonferenz;
import static demo.teil3.java8.BewerteterVortragLambdaFeatureMatchers.bewerteterVortrag;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import demo.Bewertung;
import demo.Konferenz;
import demo.Qualitaet;
import demo.Rangliste;
import demo.Service;
import demo.Vortrag;
import demo.teil1.builder.BewertungBuilder;
import demo.teil1.builder.VortragBuilder;

public class KonferenzTest {

	Service service = new Service();

	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		// Erstelle Konferenz + Speichern
		Konferenz konferenz = createStandardKonferenz().build();
		service.save(konferenz);

		// Erstelle Vortrag 1 + Speichern
		Vortrag vortrag1 = VortragBuilder.createVortrag() //
				.withTitel("Einfachere Tests") //
				.withVortragender("Franziska") //
				.withVortragender("Michael") //
				.build();
		service.save(konferenz, vortrag1);

		// Erstelle Vortrag 2 + Speichern
		Vortrag vortrag2 = VortragBuilder.createVortrag() //
				.withTitel("Object Calisthenics") //
				.withVortragender("Franziska") //
				.withVortragender("David") //
				.build();
		service.save(konferenz, vortrag2);

		// Erstelle Bewertung für Vortrag 1 + Speichern
		Bewertung bewertung1 = BewertungBuilder.createBewertung() //
				.bewerteLautstaerkeDerVortragenden(Qualitaet.MITTEL) //
				.bewerteSchauspielerischesTalent(Qualitaet.MITTEL) //
				.bewerteQualitaetDerZuhoerer(Qualitaet.EXQUISIT) //
				.bewerteAction(Qualitaet.NAJA) //
				.build();
		service.save(vortrag1, bewertung1);

		// Erstelle Bewertung für Vortrag 2 + Speichern
		Bewertung bewertung2 = BewertungBuilder.createBewertung() //
				.bewerteLautstaerkeDerVortragenden(Qualitaet.MITTEL) //
				.bewerteSchauspielerischesTalent(Qualitaet.SUPER) //
				.bewerteQualitaetDerZuhoerer(Qualitaet.EXQUISIT)//
				.bewerteAction(Qualitaet.SUPER) //
				.build();
		service.save(vortrag2, bewertung2);

		// Frage Vortrags-Ranking ab
		Rangliste rangliste = service.getVortragsRangliste(konferenz);
		assertThat(
				rangliste,
				containsInAnyOrder(
						bewerteterVortrag(23, "Einfachere Tests", bewertung1),
						bewerteterVortrag(42, "Object Calisthenics", bewertung2)));
	}
}
