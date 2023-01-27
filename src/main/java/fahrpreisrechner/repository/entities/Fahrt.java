package fahrpreisrechner.repository.entities;

import java.time.LocalDateTime;

public class Fahrt {
	
	private String id;
	private String kundeId;
	private String scooterId;
	private double zeit;
	private double distanz;
	private double kosten;
	private LocalDateTime zeitpunkt;

}
