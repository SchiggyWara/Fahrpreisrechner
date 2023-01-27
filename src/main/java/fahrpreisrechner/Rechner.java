package fahrpreisrechner;

public class Rechner {
	
	private double zeit;				// t (Zeit/Sekunden?)
	private double staerke;				// I (Stärke/Ampere)
	static final int SPANNUNG = 230;	// U (Spannung/Volt)
	private double ergebnis;
	
	// Formel: P = U * I * T
	
	private static final double STARTGEBÜHR = 1.00;
	private static final double MINUTE = 0.15;
	private static final double KILOMETER = 0.5;
	
	public static double berechnePreisMinuten(double minuten) {
		return STARTGEBÜHR + (MINUTE * minuten);
	}
	
	public static double berechnePreisKilometer(double kilometers) {
		return STARTGEBÜHR + (KILOMETER * kilometers);
	}

}
