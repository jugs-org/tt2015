package demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;

public class KonferenzTest {

	Service service = new Service();

	@Test
	public void test() {
		// Erstelle Konferenz + Speichern
		Konferenz konferenz = new Konferenz();
		konferenz.setDatum(new Date());
		konferenz.setTitel("Stuttgarter Testtage 2015");
		konferenz.setOrt(new Ort("Stuttgart", "Waldheim", 48.78, 9.18));
		service.save(konferenz);

		// Erstelle Vortrag 1 + Speichern
		Vortrag vortrag1 = new Vortrag();
		vortrag1.setTitel("Einfachere Tests");
		vortrag1.addVortragender("Franziska");
		vortrag1.addVortragender("Michael");
		service.save(konferenz, vortrag1);

		// Erstelle Vortrag 2 + Speichern
		Vortrag vortrag2 = new Vortrag();
		vortrag2.setTitel("Object Calisthenics");
		vortrag2.addVortragender("Franziska");
		vortrag2.addVortragender("David");
		service.save(konferenz, vortrag2);

		// Erstelle Bewertung für Vortrag 1 + Speichern
		Bewertung bewertung1 = new Bewertung();
		bewertung1.setLautstaerkeDerVortragenden(Qualitaet.MITTEL);
		bewertung1.setSchauspielerischesTalent(Qualitaet.MITTEL);
		bewertung1.setQualitaetDerZuhoerer(Qualitaet.EXQUISIT);
		bewertung1.setAction(Qualitaet.NAJA);
		service.save(vortrag1, bewertung1);

		// Erstelle Bewertung für Vortrag 2 + Speichern
		Bewertung bewertung2 = new Bewertung();
		bewertung2.setLautstaerkeDerVortragenden(Qualitaet.MITTEL);
		bewertung2.setSchauspielerischesTalent(Qualitaet.SUPER);
		bewertung2.setQualitaetDerZuhoerer(Qualitaet.EXQUISIT);
		bewertung2.setAction(Qualitaet.SUPER);
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
