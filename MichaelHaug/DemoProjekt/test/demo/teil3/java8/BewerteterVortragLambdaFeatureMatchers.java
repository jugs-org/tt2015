package demo.teil3.java8;

import static demo.teil2.matcher.VortragMatchers.titel;
import static demo.teil3.java8.LambdaFeatureMatcher.featureValue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;

import org.hamcrest.Matcher;

import demo.BewerteterVortrag;
import demo.Bewertung;
import demo.Vortrag;

public class BewerteterVortragLambdaFeatureMatchers {

	public static Matcher<BewerteterVortrag> bewerteterVortrag(int ranking,
			String vortragTitel, Bewertung bewertung) {
		return allOf(//
				ranking(is(ranking)), //
				vortrag(titel(is(vortragTitel))), //
				bewertung(bewertung));
	}

	public static LambdaFeatureMatcher<BewerteterVortrag, Vortrag> vortrag(
			Matcher<Vortrag> expected) {
		return featureValue(expected, "Vortrag", "Vortrag",
				bewerteterVortrag -> bewerteterVortrag.getVortrag());
	}

	public static LambdaFeatureMatcher<BewerteterVortrag, Integer> ranking(
			Matcher<Integer> expected) {
		return featureValue(expected, "Ranking", "Ranking",
				bewerteterVortrag -> bewerteterVortrag.getRanking());
	}

	public static LambdaFeatureMatcher<BewerteterVortrag, Bewertung> bewertung(
			Bewertung expected) {
		return featureValue(is(expected), "Bewertung", "Bewertung",
				bewerteterVortrag -> bewerteterVortrag.getBewertung());
	}
}
