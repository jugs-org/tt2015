package demo.teil4.unittests;

import static demo.teil1.builder.KonferenzBuilder.createStandardKonferenz;
import static demo.teil1.builder.VortragBuilder.createVortrag;
import static demo.teil2.matcher.VortragMatchers.titel;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import demo.Konferenz;
import demo.Repository;
import demo.Vortrag;

public class RepositoryTest {

	private Repository repository = new Repository();

	@Test
	public void speichertUndLaedtVortragZuKonferenz() {
		Konferenz konferenz = createStandardKonferenz() //
				.build();
		repository.persist(konferenz);

		Vortrag vortrag = createVortrag() //
				.withTitel("TDD ist toll") //
				.build();
		repository.persist(konferenz, vortrag);

		List<Vortrag> vortraege = repository.loadAllVortraege(konferenz);

		assertThat(vortraege, contains(titel(is("TDD ist toll"))));
	}
}
