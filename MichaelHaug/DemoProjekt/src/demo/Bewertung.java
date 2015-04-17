package demo;

public class Bewertung {

	private int lautstaerkeDerVortragenden;
	private int schauspielerischesTalent;
	private int qualitaetDerZuhoerer;
	private int action;

	public void setLautstaerkeDerVortragenden(int qualitaet) {
		this.lautstaerkeDerVortragenden = qualitaet;
	}

	public void setSchauspielerischesTalent(int qualitaet) {
		this.schauspielerischesTalent = qualitaet;
	}

	public void setQualitaetDerZuhoerer(int qualitaet) {
		this.qualitaetDerZuhoerer = qualitaet;
	}

	public void setAction(int qualitaet) {
		this.action = qualitaet;
	}

	public int getAction() {
		return action;
	}

	public int getLautstaerkeDerVortragenden() {
		return lautstaerkeDerVortragenden;
	}

	public int getQualitaetDerZuhoerer() {
		return qualitaetDerZuhoerer;
	}

	public int getSchauspielerischesTalent() {
		return schauspielerischesTalent;
	}

}
