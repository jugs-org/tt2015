package demo;

import java.util.ArrayList;
import java.util.List;

public class Vortrag {

	private String titel;
	private List<String> vortragende = new ArrayList<>();

	public void addVortragender(String vortragender) {
		vortragende.add(vortragender);
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getTitel() {
		return titel;
	}

	public int getAnzahlVortragende() {
		return vortragende.size();
	}

	public void addAllVortragende(List<String> vortragende) {
		this.vortragende.addAll(vortragende);
		
	}
}
