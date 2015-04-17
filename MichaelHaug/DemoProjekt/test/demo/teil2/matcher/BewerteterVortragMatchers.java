package demo.teil2.matcher;

import static demo.teil2.matcher.VortragMatchers.titel;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

import demo.BewerteterVortrag;
import demo.Bewertung;
import demo.Vortrag;

public class BewerteterVortragMatchers {

	public static Matcher<BewerteterVortrag> bewerteterVortrag(int ranking,
			String vortragTitel, Bewertung bewertung) {
		return allOf(//
				ranking(is(ranking)), //
				vortrag(titel(is(vortragTitel))), //
				bewertung(bewertung));
	}

	public static Matcher<BewerteterVortrag> vortrag(Matcher<Vortrag> expected) {
		return new FeatureMatcher<BewerteterVortrag, Vortrag>(expected,
				"Vortrag", "Vortrag") {
			@Override
			protected Vortrag featureValueOf(BewerteterVortrag actual) {
				return actual.getVortrag();
			}
		};
	}

	public static Matcher<BewerteterVortrag> ranking(Matcher<Integer> expected) {
		return new FeatureMatcher<BewerteterVortrag, Integer>(expected,
				"Ranking", "Ranking") {
			@Override
			protected Integer featureValueOf(BewerteterVortrag actual) {
				return actual.getRanking();
			}
		};
	}

	public static Matcher<BewerteterVortrag> bewertung(Bewertung expected) {
		return new FeatureMatcher<BewerteterVortrag, Bewertung>(is(expected),
				"Bewertung", "Bewertung") {
			@Override
			protected Bewertung featureValueOf(BewerteterVortrag actual) {
				return actual.getBewertung();
			}
		};
	}
}
