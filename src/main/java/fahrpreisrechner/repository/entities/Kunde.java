package fahrpreisrechner.repository.entities;

public class Kunde {
	
	private String id;
	private String nachname;
	private String vorname;
	private String telefonnummer;
	private String emailadresse;
	private String straße;
	private int hausnummer;
	private String postleitzahl;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getTelefonnummer() {
		return telefonnummer;
	}
	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}
	public String getEmailadresse() {
		return emailadresse;
	}
	public void setEmailadresse(String emailadresse) {
		this.emailadresse = emailadresse;
	}
	public String getStraße() {
		return straße;
	}
	public void setStraße(String straße) {
		this.straße = straße;
	}
	public int getHausnummer() {
		return hausnummer;
	}
	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}
	public String getPostleitzahl() {
		return postleitzahl;
	}
	public void setPostleitzahl(String postleitzahl) {
		this.postleitzahl = postleitzahl;
	}
	
}
