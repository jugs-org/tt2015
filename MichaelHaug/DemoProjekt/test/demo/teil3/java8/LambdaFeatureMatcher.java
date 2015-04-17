package demo.teil3.java8;

import java.util.function.Function;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

public class LambdaFeatureMatcher<T, U> extends FeatureMatcher<T, U> {

	public static <T, U> LambdaFeatureMatcher<T, U> featureValue(Matcher<? super U> subMatcher,
			String featureDescription, String featureName, Function<T, U> featureFunction) {
		return new LambdaFeatureMatcher<T, U>(subMatcher, featureDescription, featureName, featureFunction);
	}

	private Function<T, U> featureFunction;

	private LambdaFeatureMatcher(Matcher<? super U> subMatcher, String featureDescription, String featureName,
			Function<T, U> featureFunction) {
		super(subMatcher, featureDescription, featureName);
		this.featureFunction = featureFunction;
	}

	@Override
	protected U featureValueOf(T actual) {
		return featureFunction.apply(actual);
	}
}
