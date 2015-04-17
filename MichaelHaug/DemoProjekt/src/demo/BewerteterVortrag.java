package demo;

public class BewerteterVortrag {

	private Vortrag vortrag;
	private Bewertung bewertung;
	private int ranking;

	public BewerteterVortrag(Vortrag vortrag, Bewertung bewertung) {
		this.vortrag = vortrag;
		this.bewertung = bewertung;
	}

	public int getRanking() {
		return ranking;
	}

	public Vortrag getVortrag() {
		return vortrag;
	}

	public Bewertung getBewertung() {
		return bewertung;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

}
