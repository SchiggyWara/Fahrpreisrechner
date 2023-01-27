package fahrpreisrechner.repository.entities;

public class Scooter {

	private String id;
	private String bezeichnung;
	private double akkustand;

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}


	public void setAkkustand(double akkustand) {
		this.akkustand = akkustand;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public String getbezeichnung() {
		return bezeichnung;
	}
	
	public double getakkustand() {
		return akkustand;
	}

}
