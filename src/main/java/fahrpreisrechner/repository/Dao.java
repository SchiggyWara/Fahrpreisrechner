package fahrpreisrechner.repository;

import java.util.List;
import java.util.UUID;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.mapper.reflect.BeanMapper;

import fahrpreisrechner.Einheit;
import fahrpreisrechner.repository.entities.Kunde;
import fahrpreisrechner.repository.entities.Scooter;

public class Dao {

	private Jdbi jdbi;

	public Jdbi getJdbi() {
		return jdbi;
	}

	public void setJdbi(Jdbi jdbi) {
		this.jdbi = jdbi;
	}

	public Dao() {
	}

	public Jdbi createConnection() {

		final String URL = "jdbc:mysql://localhost:3306/scooteq";

		final String USER = "root";

		final String PASSWORD = "password";

		return Jdbi.create(URL, USER, PASSWORD);

	}

	public List<Scooter> getScooters() {

		String select = "select * from scooter";

		RowMapper<Scooter> mapper = BeanMapper.of(Scooter.class);

		return jdbi.withHandle(h -> h.createQuery(select).map(mapper).list());
	}

	public List<Kunde> getKunden() {

		String select = "SELECT * FROM kunde";

		RowMapper<Kunde> mapper = BeanMapper.of(Kunde.class);

		return jdbi.withHandle(h -> h.createQuery(select).map(mapper).list());
	}
	
	public void speicherFahrt(String kundeId, String scooterId, Einheit einheit, double einheitWert, double value) {
		
		String id = UUID.randomUUID().toString();
		
		switch(einheit) {
		case ZEIT:
			String insert = "INSERT into fahrt (id, kundeId, scooterId, zeit, distanz, kosten, zeitpunkt)" +
					" VALUES (:id, :kundeId, :scooterId, :einheitWert, :zeit, 0, NOW())";
			jdbi.withHandle(h -> h.createUpdate(insert)).bind("id", id).bind("kundeId", kundeId)
								.bind("scooterId", scooterId).bind("zeit", einheitWert).execute();
			break;
		case STRECKE:
			String insert_ = "INSERT into fahrt (id, kundeId, scooterId, zeit, distanz, kosten, zeitpunkt)" +
					" VALUES (:id, :kundeId, :scooterId, :einheitWert, 0, :distanz, NOW())";
			jdbi.withHandle(h -> h.createUpdate(insert_)).bind("id", id).bind("kundeId", kundeId)
								.bind("scooterId", scooterId).bind("distanz", einheitWert).execute();
			break;
		}
		
		
	}
}
