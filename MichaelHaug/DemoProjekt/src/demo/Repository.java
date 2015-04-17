package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {

	private Validator validator = new Validator();
	
	private Map<Konferenz, List<Vortrag>> konferenzenMitVortraegen = new HashMap<>();
	private Map<Vortrag, Bewertung> vortraegeMitBewertungen = new HashMap<>();

	public void persist(Konferenz konferenz) {
		validator.validate(konferenz);
		konferenzenMitVortraegen.put(konferenz, new ArrayList<Vortrag>());
	}

	public void persist(Vortrag vortrag, Bewertung bewertung) {
		vortraegeMitBewertungen.put(vortrag, bewertung);
	}
	
	public void persist(Konferenz konferenz, Vortrag vortrag) {
		loadAllVortraege(konferenz).add(vortrag);
	}
	
	
	public Bewertung loadAllBewertungen(Vortrag vortrag) {
		return vortraegeMitBewertungen.get(vortrag);
	}
	
	public List<Vortrag> loadAllVortraege(Konferenz konferenz) {
		return konferenzenMitVortraegen.get(konferenz);
	}

}
