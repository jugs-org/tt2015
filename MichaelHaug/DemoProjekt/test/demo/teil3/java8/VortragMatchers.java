package demo.teil3.java8;

import static demo.teil3.java8.LambdaFeatureMatcher.featureValue;

import org.hamcrest.Matcher;

import demo.Vortrag;

public class VortragMatchers {

	public static LambdaFeatureMatcher<Vortrag, String> titel(
			Matcher<String> expected) {
		return featureValue(expected, "Titel", "Titel",
				vortrag -> vortrag.getTitel());
	}
}
