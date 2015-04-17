package demo;

public class RankingBerechner {

	public BewerteterVortrag berechne(Vortrag vortrag, Bewertung bewertung) {
		BewerteterVortrag bewerteterVortrag = new BewerteterVortrag(vortrag,
				bewertung);
		bewerteterVortrag.setRanking(berechneRankingZahl(vortrag, bewertung));
		return bewerteterVortrag;
	}

	private int berechneRankingZahl(Vortrag vortrag, Bewertung bewertung) {
		return vortrag.getAnzahlVortragende() 
				- 40 * bewertung.getAction()
				+ bewertung.getLautstaerkeDerVortragenden() 
				- 5	* bewertung.getQualitaetDerZuhoerer() 
				+ 61 * bewertung.getSchauspielerischesTalent();
	}
}
