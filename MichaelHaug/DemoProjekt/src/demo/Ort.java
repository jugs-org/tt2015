package demo;

public class Ort {

	public String stadt;
	public String adresse;
	public double lattitude;
	public double longitude;

	public Ort(String stadt, String adresse, double lattitude, double longitude) {
		super();
		this.stadt = stadt;
		this.adresse = adresse;
		this.lattitude = lattitude;
		this.longitude = longitude;
	}

	public String getStadt() {
		return stadt;
	}

	public String getAdresse() {
		return adresse;
	}

	public double getLattitude() {
		return lattitude;
	}

	public double getLongitude() {
		return longitude;
	}

}
