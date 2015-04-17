package demo;

public class Validator {
	public void validate(Konferenz konferenz) {
		boolean valid = true;
		valid = valid && konferenz.getTitel() != null && konferenz.getTitel().length() >= 3;
		valid = valid && konferenz.getOrt() != null;
		valid = valid && konferenz.getDate() != null;
		if (!valid) throw new RuntimeException("Invalid Konferenz");
	}
	

}
