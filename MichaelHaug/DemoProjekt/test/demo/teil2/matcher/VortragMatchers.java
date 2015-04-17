package demo.teil2.matcher;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

import demo.Vortrag;

public class VortragMatchers {

	public static Matcher<Vortrag> titel(Matcher<String> expected) {
		return new FeatureMatcher<Vortrag, String>(expected, "Titel", "Titel") {
			@Override
			protected String featureValueOf(Vortrag actual) {
				return actual.getTitel();
			}
		};
	}
}
