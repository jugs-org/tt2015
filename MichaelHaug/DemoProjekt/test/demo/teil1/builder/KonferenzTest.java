package demo.teil1.builder;

import static demo.teil1.builder.KonferenzBuilder.createStandardKonferenz;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

import demo.BewerteterVortrag;
import demo.Bewertung;
import demo.Konferenz;
import demo.Qualitaet;
import demo.Rangliste;
import demo.Service;
import demo.Vortrag;

public class KonferenzTest {

	Service service = new Service();

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

		int gepruefteVortraege = 0;
		for (BewerteterVortrag bewerteterVortrag : rangliste) {
			if (bewerteterVortrag.getVortrag().getTitel()
					.equals("Einfachere Tests")) {
				// Ergebnis asserten (Vortrag 1)
				assertThat(bewerteterVortrag.getRanking(), is(23));
				assertThat(bewerteterVortrag.getBewertung(), is(bewertung1));
			} else if (bewerteterVortrag.getVortrag().getTitel()
					.equals("Object Calisthenics")) {
				// Ergebnis asserten (Vortrag 2)
				assertThat(bewerteterVortrag.getRanking(), is(42));
				assertThat(bewerteterVortrag.getBewertung(), is(bewertung2));
			} else {
				fail("Unbekannter Vortrag");
			}
			gepruefteVortraege++;
		}

		assertThat(gepruefteVortraege, is(2));
	}
}
