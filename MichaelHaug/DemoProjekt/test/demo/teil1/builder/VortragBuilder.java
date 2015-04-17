package demo.teil1.builder;

import java.util.LinkedList;
import java.util.List;

import demo.Vortrag;

public class VortragBuilder {

	private String titel;
	private List<String> vortragende = new LinkedList<>();

	public static VortragBuilder createVortrag() {
		return new VortragBuilder();
	}

	public VortragBuilder withTitel(String titel) {
		this.titel = titel;
		return this;
	}

	public VortragBuilder withVortragender(String name) {
		vortragende.add(name);
		return this;
	}

	public Vortrag build() {
		Vortrag vortrag = new Vortrag();
		vortrag.setTitel(titel);
		vortrag.addAllVortragende(vortragende);
		return vortrag;
	}

}
