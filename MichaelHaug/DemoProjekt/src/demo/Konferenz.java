package demo;

import java.util.Date;

public class Konferenz {

	private Date date;
	private String titel;
	private Ort ort;

	public void setDatum(Date date) {
		this.date = date;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public void setOrt(Ort ort) {
		this.ort = ort;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getTitel() {
		return titel;
	}
	
	public Ort getOrt() {
		return ort;
	}
}
