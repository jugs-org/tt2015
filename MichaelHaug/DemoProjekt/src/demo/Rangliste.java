package demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Rangliste implements Iterable<BewerteterVortrag> {

	private List<BewerteterVortrag> rangliste = new ArrayList<BewerteterVortrag>();

	@Override
	public Iterator<BewerteterVortrag> iterator() {
		return rangliste.iterator();
	}

	public void add(BewerteterVortrag bewerteterVortrag) {
		rangliste.add(bewerteterVortrag);
	}

	@Override
	public void forEach(Consumer<? super BewerteterVortrag> action) {

	}

	@Override
	public Spliterator<BewerteterVortrag> spliterator() {
		return null;
	}
}
