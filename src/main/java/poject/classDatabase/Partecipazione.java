package poject.classDatabase;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poject.classDatabase.enums.Status;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Partecipazione {

	@Id
	@GeneratedValue
	private UUID id;
	@ManyToOne
	private Persona persona;
	@ManyToOne
	private Evento evento;
	@Enumerated(EnumType.STRING)
	private Status stato;

	@Override
	public String toString() {
		return "Partecipazione [id=" + id + ", stato=" + stato + "]";
	}

	public Partecipazione(Persona persona, Evento evento, Status stato) {
		super();
		this.persona = persona;
		this.evento = evento;
		this.stato = stato;
	}
}
