package demo;

import java.util.List;

public class Service {

	private Repository repository = new Repository();
	private RankingBerechner rankingBerechner = new RankingBerechner();

	public void save(Konferenz konferenz) {
		repository.persist(konferenz);
	}

	public void save(Konferenz konferenz, Vortrag vortrag) {
		repository.persist(konferenz, vortrag);
	}

	public void save(Vortrag vortrag, Bewertung bewertung) {
		repository.persist(vortrag, bewertung);
	}

	public Rangliste getVortragsRangliste(Konferenz konferenz) {
		Rangliste rangliste = new Rangliste();
		List<Vortrag> vortraege = repository.loadAllVortraege(konferenz);
		for (Vortrag vortrag : vortraege) {
			Bewertung bewertung = repository.loadAllBewertungen(vortrag);
			BewerteterVortrag bewerteterVortrag = rankingBerechner.berechne(
					vortrag, bewertung);
			rangliste.add(bewerteterVortrag);
		}
		return rangliste;
	}
}
